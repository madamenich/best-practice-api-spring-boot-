package com.hrd.basic.myprojectapi.service;

import com.hrd.basic.myprojectapi.dto.request.RegisterRequest;
import com.hrd.basic.myprojectapi.model.User;
import com.hrd.basic.myprojectapi.utilities.Pagination;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll(Pagination pagination);
    Optional<User> findByEmail(String email);
    void create(User registerRequest);
    User findByEmailUser(String email);
}
