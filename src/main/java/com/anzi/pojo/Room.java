package com.anzi.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Room {
    @JSONField(name = "room_uid")
    public String roomUid;

    @JSONField(name = "room_name")
    public String roomName;

    public Room() {
    }

    public String getRoomUid() {
        return roomUid;
    }

    public void setRoomUid(String roomUid) {
        this.roomUid = roomUid;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("roomUid='").append(roomUid).append('\'');
        sb.append(", roomName='").append(roomName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
