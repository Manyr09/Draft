package com.practice.filmorate.controller;

import com.practice.filmorate.exception.AlreadyExistException;
import com.practice.filmorate.exception.NotFoundException;
import com.practice.filmorate.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.practice.filmorate.exception.ErrorResponse;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(final ValidationException ex) {
        return new ErrorResponse("Ошибка при валидаций.", ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(final NotFoundException ex) {
        return new ErrorResponse("Не найдено.", ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleAlreadyExistsException(final AlreadyExistException ex) {
        return new ErrorResponse("Уже существует.", ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGenericException(final Throwable ex) {
        return new ErrorResponse("Произошла непредвиденная ошибка.", ex.getMessage());
    }
}
