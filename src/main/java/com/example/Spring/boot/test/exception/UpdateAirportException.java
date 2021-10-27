package com.example.Spring.boot.test.exception;

public class UpdateAirportException extends RuntimeException {
    private String message;

    public UpdateAirportException(String message) {
        super(message);
        this.message = message;
    }
}
