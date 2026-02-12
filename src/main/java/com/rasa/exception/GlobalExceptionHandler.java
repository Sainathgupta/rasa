package com.rasa.exception;

import com.rasa.dto.RasaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RasaResponse<Void>> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(RasaResponse.fail(ex.getMessage()));
    }

    @ExceptionHandler(RasaException.class)
    public ResponseEntity<RasaResponse<Void>> handleNotFound(RasaException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(RasaResponse.fail(ex.getMessage()));
    }

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<RasaResponse<Void>> handleBusinessErrors(BusinessLogicException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(RasaResponse.fail(ex.getMessage()));
    }

    // Generic fallback for any other crash
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RasaResponse<Void>> handleGlobal(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(RasaResponse.fail("An unexpected error occurred"));
    }
}