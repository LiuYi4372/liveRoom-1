package com.anzi.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class RoomAndUser {
    @JSONField(name = "relation_uid")
    public String relationUid;


    @JSONField(name = "room_uid")
    public String roomUid;

    @JSONField(name = "user_uid")
    public String userUid;

    public RoomAndUser() {
    }

    public String getRelationUid() {
        return relationUid;
    }

    public void setRelationUid(String relationUid) {
        this.relationUid = relationUid;
    }

    public String getRoomUid() {
        return roomUid;
    }

    public void setRoomUid(String roomUid) {
        this.roomUid = roomUid;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoomAndUser{");
        sb.append("relationUid='").append(relationUid).append('\'');
        sb.append(", roomUid='").append(roomUid).append('\'');
        sb.append(", userUid='").append(userUid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
