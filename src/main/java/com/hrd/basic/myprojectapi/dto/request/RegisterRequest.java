package com.hrd.basic.myprojectapi.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "email can't be blank")
    private String email;
    @NotBlank(message = "username can't be blank")
    private String username;
    @Size(min = 8, max = 16, message
            = "password must be between 8 and 16 characters")
    private String password;
    private Set<String> roles = new HashSet<>();
}
