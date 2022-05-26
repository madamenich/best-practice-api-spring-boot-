package com.hrd.basic.myprojectapi.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface UserRoleRepository {
    @Insert("insert into mn_users_roles(user_id, role_id) values(#{userId},#{roleId})")
    void save(Integer userId, Integer roleId);
}
