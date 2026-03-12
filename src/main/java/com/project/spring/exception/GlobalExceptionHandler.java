package com.project.spring.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
     public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
          return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex){
//        String message = ex.getBindingResult()
//        .getFieldError()
//                .getDefaultMessage();
//
//        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().
                forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}