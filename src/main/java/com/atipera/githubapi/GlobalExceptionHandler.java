package com.atipera.githubapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<Map<String,String>> handleNotFound(HttpClientErrorException.NotFound ex) {
        return ResponseEntity.status(404)
                .body(Map.of(
                        "status", "404",
                        "message", "User not found or repository unavailable"
                ));
    }

}
