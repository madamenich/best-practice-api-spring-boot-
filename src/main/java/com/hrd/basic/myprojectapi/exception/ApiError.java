package com.hrd.basic.myprojectapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd@HH:mm:ss",timezone = "Asia/Phnom_Penh")
    private Date timestamp =  new Date();
    private int code;
    private String status;
    private String message;

    public ApiError(BaseApiException exception) {
        this.code = exception.getStatus().value();
        this.status = exception.getStatus().name();
        this.message = exception.getMessage();
    }
}
