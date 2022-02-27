package net.abidinozdurmaz.chess.exception;

import net.abidinozdurmaz.chess.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

import static net.abidinozdurmaz.chess.config.ProjectConstants.PROJECT_BASE_PACKAGE;

@ControllerAdvice(basePackages = {PROJECT_BASE_PACKAGE + ".controller"})
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ErrorDto dto = new ErrorDto();
        dto.setResultCode(HttpStatus.BAD_REQUEST.value());
        dto.setErrorMessage(ex.getMessage());
        dto.setResult(HttpStatus.BAD_REQUEST.name());
        return handleExceptionInternal(
                ex, dto, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ErrorDto dto = new ErrorDto();
        dto.setResultCode(HttpStatus.BAD_REQUEST.value());
        dto.setErrorMessage(
                ex.getFieldErrors().stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.joining(",")));
        dto.setResult(HttpStatus.BAD_REQUEST.name());

        return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleInternalServerError(
            InternalServerError ex, WebRequest request) {
        ErrorDto dto = new ErrorDto();
        dto.setResultCode(ex.getStatus().value());
        dto.setErrorMessage(ex.getMessage());
        dto.setResult(ex.getStatus().name());
        return handleExceptionInternal(ex, dto, new HttpHeaders(), ex.getStatus(), request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleNotFoundException(
            NotFoundException ex, WebRequest request) {
        ErrorDto dto = new ErrorDto();
        dto.setResultCode(ex.getStatus().value());
        dto.setErrorMessage(ex.getMessage());
        dto.setResult(ex.getStatus().name());
        return handleExceptionInternal(ex, dto, new HttpHeaders(), ex.getStatus(), request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleUnSupportedOperationException(
            UnSupportedOperationException ex, WebRequest request) {
        ErrorDto dto = new ErrorDto();
        dto.setResultCode(ex.getStatus().value());
        dto.setErrorMessage(ex.getMessage());
        dto.setResult(ex.getStatus().name());
        return handleExceptionInternal(ex, dto, new HttpHeaders(), ex.getStatus(), request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleBadRequestException(
            BadRequestException ex, WebRequest request) {
        ErrorDto dto = new ErrorDto();
        dto.setResultCode(ex.getStatus().value());
        dto.setErrorMessage(ex.getMessage());
        dto.setResult(ex.getStatus().name());
        return handleExceptionInternal(ex, dto, new HttpHeaders(), ex.getStatus(), request);
    }

}
