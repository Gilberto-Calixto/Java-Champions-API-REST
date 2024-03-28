package com.dev.santander.adapters.in;

import com.dev.santander.domain.exception.ChampionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ChampionNotFoundException.class)
    public ResponseEntity<ApiError> handleDomainException(ChampionNotFoundException domainError){
        return ResponseEntity
                .internalServerError()
                .body(new ApiError(domainError.getMessage()));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleDomainExceptiom(Exception unexpectedError){

        return ResponseEntity
                .internalServerError()
                .body(new ApiError("Ocorreu um erro inesperado."));
    }

    public record ApiError(String message){ }
}
