package com.hrd.basic.myprojectapi.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends BaseApiException {
    protected InternalServerErrorException(HttpStatus httpStatus, String errorMessage) {
        super(httpStatus, errorMessage);
    }
}
