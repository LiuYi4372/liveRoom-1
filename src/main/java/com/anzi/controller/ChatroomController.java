package com.anzi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anzi.model.RequestMessage;
import com.anzi.pojo.RoomAndUser;
import com.anzi.pojo.User;
import com.anzi.service.RoomAndUserService;
import com.anzi.service.RoomService;
import com.anzi.service.UserService;
import com.caclub.common.model.Response;
import com.caclub.common.utils.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


@Controller
public class ChatroomController {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomAndUserService roomAndUserService;


    @RequestMapping(value = "/chatroom/list", method = RequestMethod.GET)
    public String main() {
        return "chatroomList";
    }



    @ResponseBody
    @RequestMapping(value = "/getChatroomList", method = RequestMethod.POST)
    public String getChatroomList() {
        return FastJsonUtil.toJSONString(roomService.listRoom());
    }

    @RequestMapping(value = "/{roomUid}/chatroom", method = RequestMethod.GET)
    public String chatroom(@PathVariable("roomUid") String roomUid,Model model,HttpServletRequest request) {
        User user=(User)request.getSession().getAttribute("user");
        model.addAttribute("roomUid", roomUid);
        model.addAttribute("user", user);
        return "chatroom";
    }


    @ResponseBody
    @RequestMapping(value = "/liveRoom", method = RequestMethod.POST)
    public void liveRoom(@RequestBody String payload, HttpServletRequest request) {
        User user = JSON.parseObject(payload, User.class);
        JSONObject jsonObject=JSON.parseObject(payload);
        roomAndUserService.updateStatuse("TYP_OFF",jsonObject.getString("userUid"),jsonObject.getString("roomUid"));
    }


    @MessageMapping("/singleShout")
    public void singleUser(RequestMessage requestMessage, StompHeaderAccessor stompHeaderAccessor) {
        Principal user = stompHeaderAccessor.getUser();
        // TODO: 2020/2/27  requestMessage里面获取房间号，并查询该房间下的用户，发送消息
        List<RoomAndUser> roomAndUsers = roomAndUserService.listRecordByRoomUid(requestMessage.getRoomUid());
                roomAndUsers.stream().forEach(roomAndUser ->{
                    simpMessageSendingOperations.convertAndSendToUser(roomAndUser.getUserUid(), "/queue/shouts", requestMessage);
        });
    }
}

