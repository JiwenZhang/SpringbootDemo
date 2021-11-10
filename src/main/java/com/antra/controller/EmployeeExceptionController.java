package com.antra.controller;

import com.antra.exception.NoSuchEmployeeFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionController {
    @ExceptionHandler(value = NoSuchEmployeeFoundException.class)
    public ResponseEntity<Object> exception(NoSuchEmployeeFoundException exception) {
        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
    }
}
