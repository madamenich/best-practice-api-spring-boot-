package com.hrd.basic.myprojectapi.dto.response;


import com.hrd.basic.myprojectapi.dto.BaseResponse;
import com.hrd.basic.myprojectapi.model.User;

import java.util.Date;

public class FindOneUseresponse extends BaseResponse<User> {
    public FindOneUseresponse(int code, String message, Date requestTime, User payload) {
        super(code, message, requestTime, payload);
    }
}
