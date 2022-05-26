package com.hrd.basic.myprojectapi.dto.response;


import com.hrd.basic.myprojectapi.dto.BaseResponse;
import com.hrd.basic.myprojectapi.model.User;
import com.hrd.basic.myprojectapi.utilities.Pagination;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AllUserResponse extends BaseResponse<List<User>> {
    private Pagination pagination;
    public AllUserResponse(int code, String message, Date requestTime, List<User> data, Pagination pagination) {
        super(code, message, requestTime, data);
        this.pagination = pagination;
    }
}
