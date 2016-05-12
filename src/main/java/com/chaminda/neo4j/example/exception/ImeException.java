package com.chaminda.neo4j.example.exception;

public class ImeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ImeException(String message) {
        super(message);
    }

    public ImeException(String message, Throwable cause) {
        super(message, cause);
    }
}
