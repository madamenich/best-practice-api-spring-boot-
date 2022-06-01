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

    @Override
    public List<User> findAll(Pagination pagination) {
        pagination.setTotalCount(5);
        List<User> testList = userRepository.findAll(pagination);

//        System.out.println(testList);

//        System.out.println(user   Repository.findAll(pagination));
        return testList;
    }

    @Override
    public User findByEmail(String email) {
        User user =userRepository.findByEmail(email).get();
        System.out.println(user.getBasicInformation().getAsJsonObject());
        return user;
    }

    @Override
    public void create(User registerRequest) {
        userRepository.save(registerRequest);
    }

    @Override
    public User findByEmailUser(String email) {
        return userRepository.findByEmail(email).get();
    }
}
