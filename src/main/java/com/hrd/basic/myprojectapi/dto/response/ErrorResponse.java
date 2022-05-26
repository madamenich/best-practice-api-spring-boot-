package com.hrd.basic.myprojectapi.dto.response;



import com.hrd.basic.myprojectapi.dto.BaseErrorResponse;
import com.hrd.basic.myprojectapi.dto.payload.ErrorPayload;

import java.util.Date;
import java.util.List;

public class ErrorResponse extends BaseErrorResponse<List<ErrorPayload>> {
    public ErrorResponse(int code, String message, Date requestTime, List<ErrorPayload> error) {
        super(code, message, requestTime, error);
    }
}
