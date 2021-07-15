package com.example.desafio_quality.dtos.exceptions;

import java.util.Map;

public class GenericExceptionFieldDTO {
    private Map<String, String> errors;

    public GenericExceptionFieldDTO(Map<String, String> errors) {
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
