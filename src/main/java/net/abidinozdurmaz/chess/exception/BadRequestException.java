package net.abidinozdurmaz.chess.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends AbstractException {

    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
