package com.anzi.service.Impl;

import com.anzi.mapper.RoomAndUserMapper;
import com.anzi.pojo.RoomAndUser;
import com.anzi.service.RoomAndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAndUserServiceImpl implements RoomAndUserService {

    @Autowired
    RoomAndUserMapper roomAndUserMapper;

    @Override
    public int insertRecord(String userUid, String roomUid) {

        return roomAndUserMapper.insertRecord(userUid,roomUid);
    }

    @Override
    public List<RoomAndUser> listRecordByRoomUid(String roomUid) {
        return roomAndUserMapper.listRecordByRoomUid(roomUid);
    }

    @Override
    public int userCount(String userUid, String roomUid) {
        return roomAndUserMapper.userCount(userUid,roomUid);
    }

    @Override
    public int updateStatuse(String status, String userUid, String roomUid) {
        return roomAndUserMapper.updateStatuse(status,userUid,roomUid);
    }


}
