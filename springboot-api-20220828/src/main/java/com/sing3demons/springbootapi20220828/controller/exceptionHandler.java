package com.sing3demons.springbootapi20220828.controller;

import com.sing3demons.springbootapi20220828.exception.DataNotFoundException;
import com.sing3demons.springbootapi20220828.exception.UnprocessableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class exceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity handleDataNotFound(DataNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessageInfo(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocessableException.class)
    public ResponseEntity handleDataNotFound(UnprocessableException exception) {
        return new ResponseEntity<>(exception.getMessageInfo(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
