package com.anzi.service.Impl;

import com.anzi.mapper.UserMapper;
import com.anzi.pojo.User;
import com.anzi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user.getNickName(),user.getPhone());
    }

    @Override
    public List<User> listUserByPhone(String phone) {
        return userMapper.listUserByPhone(phone);
    }
}
