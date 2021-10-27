package com.example.Spring.boot.test.exception;

public class AirportIdException extends RuntimeException {
    private String message;

    public AirportIdException(String message) {
        super(message);
        this.message = message;
    }
}
