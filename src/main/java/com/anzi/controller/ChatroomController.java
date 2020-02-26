package com.anzi.controller;


import com.anzi.model.RequestMessage;
import com.anzi.model.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ChatroomController {

//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/responseMessage")
//    public ResponseMessage say(RequestMessage message) {
//        return new ResponseMessage(message.getName());
//    }


    @RequestMapping(value = "/chatroom",method = RequestMethod.GET)
    public String hello(){
        return "chatroom";
    }
}

