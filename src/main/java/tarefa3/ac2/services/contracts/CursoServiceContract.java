package tarefa3.ac2.services.contracts;

import java.util.List;

import tarefa3.ac2.dtos.CursoDTO;
import tarefa3.ac2.models.Curso;

public interface CursoServiceContract {
    List<CursoDTO> obterTodos();
    Curso inserir(CursoDTO cursoDTO);
    CursoDTO obterPorId(Long id);
    Curso editar(Long id, CursoDTO cursoDTO);
    void excluir(Long id);
}
