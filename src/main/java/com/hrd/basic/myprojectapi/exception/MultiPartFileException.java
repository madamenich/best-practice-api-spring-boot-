package com.hrd.basic.myprojectapi.exception;

import org.springframework.http.HttpStatus;

public class MultiPartFileException extends BaseApiException{
    public MultiPartFileException(HttpStatus httpStatus, String errorMessage) {
        super(httpStatus, errorMessage);
    }
}
