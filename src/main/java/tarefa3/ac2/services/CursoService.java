package tarefa3.ac2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tarefa3.ac2.dtos.CursoDTO;
import tarefa3.ac2.exceptions.GeneralException;
import tarefa3.ac2.models.CategoriaCurso;
import tarefa3.ac2.models.Curso;
import tarefa3.ac2.repositories.CategoriaCursoRepository;
import tarefa3.ac2.repositories.CursoRepository;
import tarefa3.ac2.services.contracts.CursoServiceContract;

@Service
public class CursoService implements CursoServiceContract{

    private CursoRepository cursoRepository;

    private CategoriaCursoRepository categoriaCursoRepository;

    public CursoService(CursoRepository cursoRepository, CategoriaCursoRepository categoriaCursoRepository){
        this.cursoRepository = cursoRepository;
        this.categoriaCursoRepository = categoriaCursoRepository;
    }

    @Override
    public List<CursoDTO> obterTodos() {
        List<CursoDTO> cursoList = cursoRepository.findAll().stream().map(
            (Curso curso) -> {
                return CursoDTO.builder()
                    .id(curso.getId())
                    .nome(curso.getNome())
                    .cargaHoraria(curso.getCargaHoraria())
                    .nomeCategoriaCurso(curso.getCategoriaCurso().getNome() != null ? 
                                        curso.getCategoriaCurso().getNome() : "Curso não possui uma categoria cadastrada!.")
                    .build();
            }
        ).collect(Collectors.toList());
        return cursoList;
    }

    @Override
    public Curso inserir(CursoDTO cursoDTO) {
        CategoriaCurso categoriaCurso = categoriaCursoRepository.findByNome(cursoDTO.getNomeCategoriaCurso()).orElseThrow(() -> new GeneralException("Não foi possível encontrar a categoria pelo nome!."));
        Curso curso = new Curso();
        curso.setId(null);
        curso.setNome(cursoDTO.getNome());
        curso.setCargaHoraria(cursoDTO.getCargaHoraria());
        curso.setCategoriaCurso(categoriaCurso);
        return cursoRepository.save(curso);
    }

    @Override
    public CursoDTO obterPorId(Long id) {
        return cursoRepository.findById(id).map(
            (Curso curso) -> {
                return CursoDTO.builder()
                               .id(curso.getId())
                               .nome(curso.getNome())
                               .cargaHoraria(curso.getCargaHoraria())
                               .nomeCategoriaCurso(curso.getCategoriaCurso().getNome() != null ?
                               curso.getCategoriaCurso().getNome() : "Curso não possui uma categoria cadastrada!.")
                               .build();
            }
        ).orElseThrow(() -> new GeneralException("Id do curso não encontrado na base!."));
    }

    @Override
    public Curso editar(Long id, CursoDTO cursoDTO) {
        CursoDTO oldCurso = this.obterPorId(id);
        CategoriaCurso categoriaCurso = categoriaCursoRepository.findByNome(cursoDTO.getNomeCategoriaCurso()).orElseThrow(() -> new GeneralException("Não foi possível encontrar a categoria pelo nome!."));
        Curso curso = new Curso();
        curso.setId(oldCurso.getId());
        curso.setNome(oldCurso.getNome());
        curso.setCargaHoraria(oldCurso.getCargaHoraria());
        curso.setCategoriaCurso(categoriaCurso);
        return cursoRepository.save(curso);
    }

    @Override
    public void excluir(Long id) {
        this.cursoRepository.deleteById(id);
    }
}
