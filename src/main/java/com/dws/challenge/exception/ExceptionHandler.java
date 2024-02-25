package com.dws.challenge.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> notFound(ResourceNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }
}
