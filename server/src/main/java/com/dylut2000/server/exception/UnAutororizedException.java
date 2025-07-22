package com.dylut2000.server.exception;

public class UnAutororizedException extends RuntimeException {
    public UnAutororizedException(String message) {
        super(message);
    }
}
