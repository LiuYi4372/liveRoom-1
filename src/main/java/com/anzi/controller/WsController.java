package com.anzi.controller;

import com.anzi.model.RequestMessage;
import com.anzi.model.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/getResponse")
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("welcome," + message.getName() + " !");
    }


    @RequestMapping(value = "/ws",method = RequestMethod.GET)
    public String viewMyresume(){
        return "ws";
    }
}
