package tarefa3.ac2.services.contracts;

import java.util.List;

import tarefa3.ac2.dtos.CategoriaCursoDTO;
import tarefa3.ac2.models.CategoriaCurso;

public interface CategoriaCursoServiceContract {
    List<CategoriaCursoDTO> obterTodos();
    CategoriaCurso inserir(CategoriaCursoDTO categoriaCursoDTO);
    CategoriaCursoDTO obterPorId(Long id);
    CategoriaCurso editar(Long id, CategoriaCursoDTO categoriaCursoDTO);
    void excluir(Long id);
}
