package tarefa3.ac2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import tarefa3.ac2.dtos.exceptionDTO.ApiErrorDTO;
import tarefa3.ac2.exceptions.GeneralException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApplicationControllerAdvice {
    
    @ExceptionHandler(GeneralException.class)
    public ApiErrorDTO handleGeneralException(GeneralException generalException){
        String error = generalException.getMessage();
        return new ApiErrorDTO(error);
    }
}
