package tarefa3.ac2.services.contracts;

import java.util.List;

import tarefa3.ac2.dtos.CategoriaCursoDTO;
import tarefa3.ac2.dtos.CategoriaCursoInserirDTO;

public interface CategoriaCursoServiceContract {
    List<CategoriaCursoDTO> obterTodos();
    CategoriaCursoInserirDTO inserir(CategoriaCursoInserirDTO categoriaCursoDTO);
    CategoriaCursoDTO obterPorId(Long id);
    CategoriaCursoDTO editar(Long id, CategoriaCursoDTO categoriaCursoDTO);
    void excluir(Long id);
}
