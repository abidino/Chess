package net.abidinozdurmaz.chess.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractException extends RuntimeException {

    private final String message;

    public AbstractException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public abstract HttpStatus getStatus();
}
