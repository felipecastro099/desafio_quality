package com.example.desafio_quality.dtos.exceptions;

public class GenericExceptionDTO {

    private String message;

    public GenericExceptionDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
