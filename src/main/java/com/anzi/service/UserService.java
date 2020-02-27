package com.anzi.service;

import com.anzi.pojo.User;

import java.util.List;

public interface UserService {
    int insertUser(User user);
    List<User> listUserByPhone(String phone);
}
