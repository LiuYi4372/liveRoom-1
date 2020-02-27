package com.anzi.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JSONField(name = "user_uid")
    public String userUid;

    @JSONField(name = "nick_name")
    public String nickName;

    @JSONField(name = "phone")
    public String phone;

    public User() {
    }

    public User(String nickName, String phone) {
        this.nickName = nickName;
        this.phone = phone;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String headImgUrl) {
        this.phone = headImgUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userUid='").append(userUid).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
