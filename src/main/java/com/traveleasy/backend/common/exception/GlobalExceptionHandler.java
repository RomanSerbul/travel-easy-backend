package com.traveleasy.backend.common.exception;

import com.traveleasy.backend.common.dto.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;
import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleDomainException(DomainException ex) {
        var body = Map.of(
                "message", ex.getMessage(),
                "type", "DOMAIN_ERROR"
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.of(body));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, Serializable>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        var errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(java.util.LinkedHashMap<String, String>::new,
                        (acc, fieldError) -> acc.put(fieldError.getField(), fieldError.getDefaultMessage()),
                        java.util.LinkedHashMap::putAll);
        var body = Map.of(
                "message", "Validation failed",
                "errors", errors
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ApiResponse.of(body));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<Map<String, Object>>> handleConstraintViolation(ConstraintViolationException ex) {
        var body = Map.of(
                "message", "Constraint violation",
                "violations", ex.getConstraintViolations().stream()
                        .map(violation -> Map.of(
                                "property", violation.getPropertyPath().toString(),
                                "message", violation.getMessage()))
                        .toList()
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ApiResponse.of(body));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneric(Exception ex) {
        var body = Map.of(
                "timestamp", Instant.now().toString(),
                "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
