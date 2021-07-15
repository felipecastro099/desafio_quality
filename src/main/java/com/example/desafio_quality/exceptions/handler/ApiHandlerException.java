package com.example.desafio_quality.exceptions.handler;

import com.example.desafio_quality.dtos.exceptions.GenericExceptionDTO;
import com.example.desafio_quality.dtos.exceptions.GenericExceptionFieldDTO;
import com.example.desafio_quality.exceptions.NotFoundException;
import com.example.desafio_quality.utils.exceptions.FieldErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApiHandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> sellerNotFound(NotFoundException notFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericExceptionDTO(notFoundException.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValidHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();
        GenericExceptionFieldDTO exceptions = FieldErrors.processFieldErrors(fieldErrors);

        return ResponseEntity.badRequest().body(exceptions);
    }
}
