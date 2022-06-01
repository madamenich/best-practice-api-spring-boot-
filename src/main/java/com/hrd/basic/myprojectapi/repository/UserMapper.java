package com.hrd.basic.myprojectapi.repository;

import com.hrd.basic.myprojectapi.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  public User getUser(String email);
}
