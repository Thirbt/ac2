package tarefa3.ac2.mappers;

import tarefa3.ac2.dtos.CursoDTO;
import tarefa3.ac2.models.Curso;

public class CursoMapper {

    public CursoDTO convertCursoToDTO(Curso curso){
        return new CursoDTO(curso.getId(),
                            curso.getNome(),
                            curso.getCargaHoraria(),
                            curso.getCategoriaCurso().getNome());
    }
}
