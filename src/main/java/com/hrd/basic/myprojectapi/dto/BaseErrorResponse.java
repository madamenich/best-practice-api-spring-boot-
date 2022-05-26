package com.hrd.basic.myprojectapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**********************************************************************
 * Original Author: Huot Chansreynich
 * Created Date: 12/07/2021
 * Development Group: HRD Group
 * Description: Default Error Response Class
 **********************************************************************/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseErrorResponse<T>{
    private int code;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss",timezone = "Asia/Phnom_Penh")
    private Date requestTime;
    private T error;
}