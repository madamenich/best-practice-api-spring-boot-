package com.hrd.basic.myprojectapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.NotNull;

@RestControllerAdvice
public class ControllerAdviser extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    public ResponseEntity<Object> handleFileUploadException(MultipartException ex) {
        return getErrorResponse(new BaseApiException(HttpStatus.PAYLOAD_TOO_LARGE,"Maximum upload size of 20MB exceeded"));
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNullException(NullPointerException ex) {
        return getErrorResponse(new BaseApiException(HttpStatus.NOT_FOUND,"Not Found"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex) {
        return getErrorResponse(new BaseApiException(HttpStatus.BAD_REQUEST,ex.getMessage()));
    }

    @NotNull
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getErrorResponse(new BaseApiException(HttpStatus.BAD_REQUEST,ex.getMessage()));
    }

    private ResponseEntity<Object> getErrorResponse(BaseApiException apiException) {
        return new ResponseEntity<>(new ApiError(apiException), apiException.getStatus());
    }
}
