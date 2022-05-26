package com.hrd.basic.myprojectapi.exception;

public class UserNotLoggInYetException extends RuntimeException{
    public UserNotLoggInYetException(String message) {
        super(message);
    }
}
