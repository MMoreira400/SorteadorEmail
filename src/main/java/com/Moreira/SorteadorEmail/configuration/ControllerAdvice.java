package com.Moreira.SorteadorEmail.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<List<FieldErrorResponse>> onValidationError(MethodArgumentNotValidException ex) {
        List<FieldErrorResponse> fieldErrorResponse =  ex.getAllErrors().stream().map(error -> {
            FieldError fieldError = (FieldError) error;
            return new FieldErrorResponse(fieldError.getDefaultMessage());
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrorResponse);
    }

}
