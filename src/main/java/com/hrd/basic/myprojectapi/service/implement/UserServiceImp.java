package com.hrd.basic.myprojectapi.service.implement;

import com.hrd.basic.myprojectapi.dto.request.RegisterRequest;
import com.hrd.basic.myprojectapi.model.User;
import com.hrd.basic.myprojectapi.repository.UserMapper;
import com.hrd.basic.myprojectapi.repository.UserRepository;
import com.hrd.basic.myprojectapi.service.UserService;
import com.hrd.basic.myprojectapi.utilities.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    @Override
    public List<User> findAll(Pagination pagination) {
        pagination.setTotalCount(5);
        return userRepository.findAll(pagination);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void create(User registerRequest) {
        userRepository.save(registerRequest);
    }

    @Override
    public User findByEmailUser(String email) {
        return mapper.getUser(email);
    }
}
