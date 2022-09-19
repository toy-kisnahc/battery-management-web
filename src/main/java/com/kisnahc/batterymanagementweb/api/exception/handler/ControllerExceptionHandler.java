package com.kisnahc.batterymanagementweb.api.exception.handler;

import com.kisnahc.batterymanagementweb.api.exception.ErrorResponse;
import com.kisnahc.batterymanagementweb.api.exception.GlobalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Objects;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;


@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> unexpectedTypeException(MethodArgumentNotValidException e) {

        ErrorResponse body = ErrorResponse.builder()
                .statusCode(SC_BAD_REQUEST)
                .message(Objects.requireNonNull(e.getFieldError()).getDefaultMessage())
                .reason(Map.of(e.getFieldError().getField(), Objects.requireNonNull(e.getFieldError().getRejectedValue()).toString()))
                .build();

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> globalException(GlobalException e) {

        ErrorResponse body = ErrorResponse.builder()
                .statusCode(e.getStatusCode())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(e.getStatusCode()).body(body);
    }
}
