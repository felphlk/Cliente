package com.test.api.cliente.error;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    private ResponseEntity<Object> handleBadRequest(ObjectNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<Object> handleBadRequest(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Elemento não encontrado");
    }
}
