package com.anzi.model;

import com.alibaba.fastjson.annotation.JSONField;

public class RequestMessage {
    @JSONField(name="room_uid")
    private String roomUid;

    @JSONField(name="nick_name")
    private String nickName;

    @JSONField(name="head_img_url")
    private String headImgUrl;

    @JSONField(name="message")
    private String message;

    public String getRoomUid() {
        return roomUid;
    }

    public void setRoomUid(String roomUid) {
        this.roomUid = roomUid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RequestMessage{");
        sb.append("roomUid='").append(roomUid).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", headImgUrl='").append(headImgUrl).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


