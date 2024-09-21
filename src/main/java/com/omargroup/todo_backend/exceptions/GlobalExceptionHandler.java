package com.omargroup.todo_backend.exceptions;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        // Create a response body that includes the custom error message
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());  // 404
        body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());  // "Not Found"
        body.put("message", ex.getMessage());  // Exception message
        body.put("path", request.getDescription(false).substring(4));  // Requested path

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}