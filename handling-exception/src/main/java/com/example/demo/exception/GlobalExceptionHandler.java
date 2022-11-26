package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value
            = CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                ex.getMessage());
    }

    @ExceptionHandler(value
            = NoSuchCustomerExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse
    handleException(NoSuchCustomerExistsException ex) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }


}
