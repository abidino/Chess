package net.abidinozdurmaz.chess.exception;

import org.springframework.http.HttpStatus;

public class InternalServerError extends AbstractException {
    public InternalServerError(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
