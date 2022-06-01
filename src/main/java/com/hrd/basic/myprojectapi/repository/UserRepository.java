package com.hrd.basic.myprojectapi.repository;

import com.google.gson.JsonElement;
import com.hrd.basic.myprojectapi.dto.request.RegisterRequest;
import com.hrd.basic.myprojectapi.model.ERole;
import com.hrd.basic.myprojectapi.model.Role;
import com.hrd.basic.myprojectapi.model.User;
import com.hrd.basic.myprojectapi.utilities.Pagination;
import com.hrd.basic.myprojectapi.utilities.json.JsonElementTypeHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Mapper
@Repository
public interface UserRepository  {

    //TODO:  fetch all users

    @Select("select * from mn_users order by id desc limit #{p.limit} offset #{p.offset}")
    @Results(id="ResultUser", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "status", column = "status"),
            @Result(property = "createAt", column = "create_at"),
            @Result(property = "updateAt", column = "update_at"),
            @Result(property = "basicInformation", column = "basic_information",typeHandler = JsonElementTypeHandler.class),
            @Result(property = "roles", column = "id", many = @Many(select = "findAllRolesByUserId"))

    })
    List<User> findAll(@Param("p") Pagination pagination);

    @Select("select r.role_id, r.role_name\n" +
            "from mn_roles r\n" +
            "    inner join mn_users_roles mur on r.role_id = mur.role_id\n" +
            "where mur.user_id =#{userId}")
    @Results(value = {
            @Result(property = "id", column = "role_id"),
            @Result(property = "name",column = "role_name",javaType = ERole.class)
    })
    Set<Role> findAllRolesByUserId(Integer userId);

    @Select("select * from mn_users where email = #{email}")
    @ResultMap("ResultUser")
    Optional<User> findByEmail(String email);

    @Insert("insert into mn_users(username, email, password, created_at, updated_at, status, basic_information)values (#{u.username},#{u.email},#{u.password},#{u.createAt},#{u.updateAt},#{u.status}, #{u.basicInformation,typeHandler=com.hrd.basic.myprojectapi.utilities.json.JsonElementTypeHandler})")
    void save(@Param("u") User user);

}
