package com.example.demo.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
    private String message;
    CustomerAlreadyExistsException( ){}

    public CustomerAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }

}
