package com.example.ClinicaVet.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ApiErrorMessage {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> notFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorValidArguments>> notValidArguments(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors().stream().map(ErrorValidArguments::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    public record ErrorValidArguments(String field, String msg) {
        public ErrorValidArguments(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
