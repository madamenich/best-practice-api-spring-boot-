package com.hrd.basic.myprojectapi.utilities;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class CustomMessage {
    public static final String BAD_REQUEST = "Bad Request";
    private static final String SUCCESSFULLY_RETRIEVED = "retrieved successfully";
    public static final String SUCCESSFULLY_UPDATED = "successfully updated";
    public static final String NOT_FOUND = "Not Found";
    public static final String VALIDATION_ERROR = "Validation Error";
    public static final String SUCCESSFULLY_CREATED = "created successfully";
    public static final String SUCCESSFULLY_DELETED = "deleted successfully";
    public static final String SUCCESSFULLY_SUMMITED = "summited successfully";
}
