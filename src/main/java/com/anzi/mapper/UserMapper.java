package com.anzi.mapper;

import com.anzi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int insertUser(@Param("nickName")String nickName,@Param("phone")String phone);
    List<User> listUserByPhone(@Param("phone")String phone);
}
