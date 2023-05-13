package com.example.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        var msg = resourceNotFoundException.getMessage();
        ApiResponse res = ApiResponse.builder().msg(msg).success(true).build();
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
