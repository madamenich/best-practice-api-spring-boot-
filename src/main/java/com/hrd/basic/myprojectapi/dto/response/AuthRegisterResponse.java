package com.hrd.basic.myprojectapi.dto.response;



import com.hrd.basic.myprojectapi.dto.BaseResponse;
import com.hrd.basic.myprojectapi.dto.request.RegisterRequest;

import java.util.Date;


public class AuthRegisterResponse extends BaseResponse<RegisterRequest> {
    public AuthRegisterResponse(int code, String message, Date requestTime, RegisterRequest payload) {
        super(code, message, requestTime, payload);
    }
}
