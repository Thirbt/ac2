package tarefa3.ac2.dtos.exceptionDTO;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class ApiErrorDTO {

    private List<String> erros;

    public ApiErrorDTO(String mensagem){
        this.erros = Arrays.asList(mensagem);
    }
    
}
