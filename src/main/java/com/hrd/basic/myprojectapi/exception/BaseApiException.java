package com.hrd.basic.myprojectapi.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseApiException extends RuntimeException {
    protected HttpStatus status;
    protected String message;

    public BaseApiException(HttpStatus httpStatus, String errorMessage) {
        this.status = httpStatus;
        this.message = errorMessage;
    }
}
