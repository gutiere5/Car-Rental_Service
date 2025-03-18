package com.noel.controller;

import com.noel.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
@ResponseStatus
public class AppExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidParameters(MethodArgumentNotValidException e) {
        return new ErrorMessage(400, e.getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorMessage notFound(NoSuchElementException e) {
        return new ErrorMessage(404, "Not Found");
    }

}
