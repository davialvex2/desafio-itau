package com.daviaugusto.desafio_itau.infrastructure.exceptions;

public class UnprocessableException extends RuntimeException{

    public UnprocessableException(String mensagem){
        super(mensagem);
    }

}
