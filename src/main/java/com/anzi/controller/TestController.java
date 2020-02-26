package com.anzi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/helloWorld.html", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("now",new SimpleDateFormat("yyyy-MM").format(new Date()));
        return "hello";
    }
}

