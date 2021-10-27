package com.example.Spring.boot.test.exception;

public class PassengerIdNotFoundException extends RuntimeException{
    private String message;

    public PassengerIdNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
