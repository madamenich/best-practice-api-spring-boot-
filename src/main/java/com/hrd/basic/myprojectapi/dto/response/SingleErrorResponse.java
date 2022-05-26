package com.hrd.basic.myprojectapi.dto.response;


import com.hrd.basic.myprojectapi.dto.BaseErrorResponse;

import java.util.Date;

public class SingleErrorResponse extends BaseErrorResponse<String> {
    public SingleErrorResponse(int code, String message, Date requestTime, String error) {
        super(code, message, requestTime, error);
    }
}
