package com.anzi.controller;

import com.alibaba.fastjson.JSONObject;
import com.anzi.model.RequestMessage;
import com.anzi.util.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;


@Controller
public class ChatroomController {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @RequestMapping(value = "/{userUid}/{roomUid}/chatroom", method = RequestMethod.GET)
    public String chatroom(@PathVariable("roomUid") String roomUid,@PathVariable("userUid") String userUid, Model model) {
        model.addAttribute("roomUid", roomUid);
        model.addAttribute("userUid", userUid);
        return "chatroom";
    }

    /**
     * 广播
     * @param payload
     * @return
     */
    @MessageMapping("/topicMessage")
    @SendTo("/topic/topicMessage")
    public String responseTopicMessage(String payload) {
        RequestMessage requestMessage = JSONObject.parseObject(payload, RequestMessage.class);
        return FastJsonUtil.toJSONString(requestMessage);
    }

//    /**
//     * 这里用的是@SendToUser，这就是发送给单一客户端的标志。本例中，
//     * 客户端接收一对一消息的主题应该是“/user/” + 用户Id + “/message” ,这里的用户id可以是一个普通的字符串，只要每个用户端都使用自己的id并且服务端知道每个用户的id就行。
//     * @return
//     */
//    @MessageMapping("/userMessage")
//    @SendToUser("/userMessage")
//    public String responseUserMessage(String payload) {
//        RequestMessage requestMessage = JSONObject.parseObject(payload, RequestMessage.class);
//        return FastJsonUtil.toJSONString(requestMessage);
//    }

    @MessageMapping("/singleShout")
    public void singleUser(RequestMessage requestMessage, StompHeaderAccessor stompHeaderAccessor) {
//        Principal user = stompHeaderAccessor.getUser();
        // TODO: 2020/2/27  requestMessage里面获取房间号，并查询该房间下的用户，发送消息
        simpMessageSendingOperations.convertAndSendToUser("333", "/queue/shouts", requestMessage);
    }

}

