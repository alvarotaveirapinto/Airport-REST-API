package com.example.Spring.boot.test.exception;

public class PassengerNameNotFound extends RuntimeException{
    private String message;

    public PassengerNameNotFound(String message) {
        super(message);
        this.message = message;
    }
}
