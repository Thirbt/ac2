package tarefa3.ac2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tarefa3.ac2.dtos.CategoriaCursoDTO;
import tarefa3.ac2.models.CategoriaCurso;
import tarefa3.ac2.services.contracts.CategoriaCursoServiceContract;

@Service
public class CategoriaCursoService implements CategoriaCursoServiceContract {

    @Override
    public List<CategoriaCursoDTO> obterTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
    }

    @Override
    public CategoriaCurso inserir(CategoriaCursoDTO categoriaCursoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

    @Override
    public CategoriaCursoDTO obterPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterPorId'");
    }

    @Override
    public CategoriaCurso editar(Long id, CategoriaCursoDTO categoriaCursoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editar'");
    }

    @Override
    public void excluir(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    
}
