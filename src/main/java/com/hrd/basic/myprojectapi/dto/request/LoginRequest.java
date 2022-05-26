package com.hrd.basic.myprojectapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**********************************************************************
 * Original Author: Huot Chansreynich
 * Created Date: 12/07/2021
 * Development Group: HRD Group
 * Description: Login Request Class
 **********************************************************************/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "username can't be blank")
    private String username;
    @NotBlank(message = "password can't be blank")
    private String password;
}
