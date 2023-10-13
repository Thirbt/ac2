package tarefa3.ac2.services.contracts;

import java.util.List;

import tarefa3.ac2.dtos.CursoDTO;
import tarefa3.ac2.dtos.CursoInserirDTO;

public interface CursoServiceContract {
    List<CursoDTO> obterTodos();
    CursoInserirDTO inserir(CursoInserirDTO cursoDTO);
    CursoDTO obterPorId(Long id);
    CursoDTO editar(Long id, CursoDTO cursoDTO);
    void excluir(Long id);
}
