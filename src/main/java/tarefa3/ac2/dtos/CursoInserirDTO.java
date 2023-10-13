package tarefa3.ac2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoInserirDTO {
    private String nome;
    private Integer cargaHoraria;
    private String nomeCategoriaCurso;
}
