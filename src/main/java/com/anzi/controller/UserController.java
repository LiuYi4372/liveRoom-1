package com.anzi.controller;

import com.alibaba.fastjson.JSON;
import com.anzi.pojo.User;
import com.anzi.service.UserService;
import com.caclub.common.model.Response;
import com.caclub.common.utils.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }


    @ResponseBody
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String create(@RequestBody String payload, HttpServletRequest request) {
        User user = JSON.parseObject(payload, User.class);
        List<User> users = userService.listUserByPhone(user.getPhone());
        if (users.size() > 0) {
            request.getSession().setAttribute("user", users.get(0));
            return FastJsonUtil.toJSONString(Response.success("success"));
        }

        int index = userService.insertUser(user);
        if (index <= 0) {
            throw new RuntimeException("注册失败");
        }

        request.getSession().setAttribute("user", userService.listUserByPhone(user.getPhone()).get(0));
        return FastJsonUtil.toJSONString(Response.success("success"));

    }
}
