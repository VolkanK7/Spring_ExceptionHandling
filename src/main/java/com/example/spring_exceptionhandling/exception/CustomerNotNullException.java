package com.example.spring_exceptionhandling.exception;

public class CustomerNotNullException extends RuntimeException{
    public CustomerNotNullException(String message) {
        super(message);
    }
}
