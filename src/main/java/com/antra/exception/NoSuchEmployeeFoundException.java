package com.antra.exception;

public class NoSuchEmployeeFoundException extends RuntimeException {
    private String message;

    public NoSuchEmployeeFoundException() {
    }

    public NoSuchEmployeeFoundException(String message) {
        super(message);
    }
}
