package com.spring.java.phoneshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiServiceException.class)
    public ResponseEntity<?> handleHttpClientError(ApiServiceException e) {
        //@TODO customize response
        return ResponseEntity.status(e.getStatus()).body(e);
    }
}
