package tarefa3.ac2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tarefa3.ac2.dtos.CategoriaCursoDTO;
import tarefa3.ac2.dtos.CategoriaCursoInserirDTO;
import tarefa3.ac2.exceptions.GeneralException;
import tarefa3.ac2.mappers.CategoriaCursoMapper;
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
    public CategoriaCursoInserirDTO inserir(CategoriaCursoInserirDTO categoriaCursoInserirDTO) {
        CategoriaCursoInserirDTO categoria = CategoriaCursoInserirDTO.builder()
                                      .nome(categoriaCursoInserirDTO.getNome())
                                      .build();

        categoriaCursoRepository.save(CategoriaCursoMapper.convertCategoriaInserirDTOToEntity(categoriaCursoInserirDTO));

        return categoria;
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
    public CategoriaCursoDTO editar(Long id, CategoriaCursoDTO categoriaCursoDTO) {
        CategoriaCurso oldCategoria = categoriaCursoRepository.findById(id).orElseThrow(() -> new GeneralException("Id da categoria não encontrada dentro da base!."));

        CategoriaCursoDTO categoriaCurso = CategoriaCursoDTO.builder()
                                            .id(oldCategoria.getId())
                                            .nome(categoriaCursoDTO.getNome())
                                            .build();

        categoriaCursoRepository.save(CategoriaCursoMapper.convertCategoriaDTOToEntity(categoriaCursoDTO, oldCategoria.getId(), oldCategoria));

        return categoriaCurso;
    }

    @Override
    public void excluir(Long id) {
        this.categoriaCursoRepository.deleteById(id);
    }
}
