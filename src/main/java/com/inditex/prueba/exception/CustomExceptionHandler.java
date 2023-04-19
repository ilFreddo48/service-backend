package com.inditex.prueba.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger loggerException = LogManager.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler({GlobalException.class})
    public ResponseEntity globalExceptionHandler(GlobalException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        loggerException.error(ex);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({InvalidDateFormatException.class})
    public ResponseEntity parameterNotFoundExceptionHandler(InvalidDateFormatException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        loggerException.error(ex);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}