package com.hrd.basic.myprojectapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private boolean status = true;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss",timezone = "Asia/Phnom_Penh")
    private Date createAt = new Date();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss",timezone = "Asia/Phnom_Penh")
    private Date updateAt = new Date();
    private Set<Role> roles = new HashSet<>();

    public User(String username, String password) {
    }
}
