package com.arun.ssrf;

import org.springframework.boot.http.client.FilteredHostException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FilteredHostException.class)
    public ResponseEntity<String> handleFilteredHostException(
            FilteredHostException exception) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The supplied URL points to a restricted destination.");
    }
}
