package tarefa3.ac2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tarefa3.ac2.dtos.CategoriaCursoDTO;
import tarefa3.ac2.exceptions.GeneralException;
import tarefa3.ac2.models.CategoriaCurso;
import tarefa3.ac2.repositories.CategoriaCursoRepository;
import tarefa3.ac2.services.contracts.CategoriaCursoServiceContract;

@Service
public class CategoriaCursoService implements CategoriaCursoServiceContract {

    private CategoriaCursoRepository categoriaCursoRepository;

    public CategoriaCursoService(CategoriaCursoRepository categoriaCursoRepository){
        this.categoriaCursoRepository = categoriaCursoRepository;
    }

    @Override
    public List<CategoriaCursoDTO> obterTodos() {
        List<CategoriaCursoDTO> categoriaList = categoriaCursoRepository.findAll().stream().map(
            (CategoriaCurso categoria) -> {
                return CategoriaCursoDTO.builder()
                    .id(categoria.getId())
                    .nome(categoria.getNome())
                    .build();
            }
        ).collect(Collectors.toList());
        return categoriaList;
    }

    @Override
    public CategoriaCurso inserir(CategoriaCursoDTO categoriaCursoDTO) {
        CategoriaCurso categoria = new CategoriaCurso();
        categoria.setId(null);
        categoria.setNome(categoriaCursoDTO.getNome());
        categoria.setCursos(null);
        return categoriaCursoRepository.save(categoria);
    }

    @Override
    public CategoriaCursoDTO obterPorId(Long id) {
        return categoriaCursoRepository.findById(id).map(
            (CategoriaCurso categoria) -> {
                return CategoriaCursoDTO.builder()
                    .id(categoria.getId())
                    .nome(categoria.getNome())
                    .build();       
            }
        ).orElseThrow(() -> new GeneralException("Id da categoria não encontrada dentro da base!."));
    }

    @Override
    public CategoriaCurso editar(Long id, CategoriaCursoDTO categoriaCursoDTO) {
        CategoriaCursoDTO oldCategoria = this.obterPorId(id);
        CategoriaCurso categoriaCurso = new CategoriaCurso();
        categoriaCurso.setId(oldCategoria.getId());
        categoriaCurso.setNome(oldCategoria.getNome());
        return categoriaCursoRepository.save(categoriaCurso);
    }

    @Override
    public void excluir(Long id) {
        this.categoriaCursoRepository.deleteById(id);
    }
}
