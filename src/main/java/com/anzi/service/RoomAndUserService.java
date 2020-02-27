package com.anzi.service;

import com.anzi.pojo.RoomAndUser;
import com.anzi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomAndUserService {
    int insertRecord(String userUid, String roomUid);
    List<RoomAndUser> listRecordByRoomUid(String roomUid);
    int userCount(String userUid,String roomUid);
    int updateStatuse(String status,String userUid,String roomUid);
}
