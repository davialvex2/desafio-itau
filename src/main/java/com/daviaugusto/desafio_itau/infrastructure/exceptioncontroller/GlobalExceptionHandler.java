package com.daviaugusto.desafio_itau.infrastructure.exceptioncontroller;


import com.daviaugusto.desafio_itau.infrastructure.exceptions.UnprocessableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(UnprocessableException.class)
    public ResponseEntity<String> unprocessable (UnprocessableException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleJsonInvalido(HttpMessageNotReadableException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("JSON malformado ou com dados inválidos.");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullpoint (NullPointerException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Os dados não foram passados");
    }

}
