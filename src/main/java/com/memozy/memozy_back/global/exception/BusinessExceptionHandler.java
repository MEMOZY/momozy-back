package com.memozy.memozy_back.global.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;


@Slf4j
@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        log.error("BusinessException : {}", e.getErrorCode().getMessage(), e);
        return ErrorResponse.createErrorResponseEntity(e.getErrorCode());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.error("BindException : {}", e.getMessage(), e);
        FieldError fieldError = Objects.requireNonNull(e.getFieldError());
        return ErrorResponse.createErrorResponseEntity(
                ErrorCode.INVALID_INPUT_VALUE,
                String.format("%s (%s)",
                        fieldError.getDefaultMessage(),
                        fieldError.getField()));
    }

    @ExceptionHandler({
            MethodArgumentTypeMismatchException.class,
            IllegalArgumentException.class,
            HttpMessageNotReadableException.class,
            InvalidFormatException.class,
            ServletRequestBindingException.class
    })
    public ResponseEntity<ErrorResponse> handleBadRequestException(Exception e) {
        log.error("Exception : {}", e.getMessage(), e);
        return ErrorResponse.createErrorResponseEntity(ErrorCode.INVALID_INPUT_VALUE);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(Exception e) {
        log.error("NotFoundException : {}", e.getMessage(), e);
        return ErrorResponse.createErrorResponseEntity(ErrorCode.NOT_FOUND_RESOURCE_EXCEPTION);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException e) {
        log.error("NoHandlerFoundException : {}", e.getMessage(), e);
        return ErrorResponse.createErrorResponseEntity(ErrorCode.NOT_FOUND_HANDLER_EXCEPTION);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("Exception : {}", e.getMessage(), e);
        return ErrorResponse.createErrorResponseEntity(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}

