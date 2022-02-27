package net.abidinozdurmaz.chess.exception;

import org.springframework.http.HttpStatus;

public class UnSupportedOperationException extends AbstractException {
    public UnSupportedOperationException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.METHOD_NOT_ALLOWED;
    }
}
