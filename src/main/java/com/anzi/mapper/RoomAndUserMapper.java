package com.anzi.mapper;

import com.anzi.pojo.RoomAndUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomAndUserMapper {
    int insertRecord(@Param("userUid") String userUid, @Param("roomUid") String roomUid);
    List<RoomAndUser> listRecordByRoomUid(@Param("roomUid") String roomUid);
    int userCount(@Param("userUid") String userUid, @Param("roomUid") String roomUid);
    int updateStatuse(@Param("status") String status,@Param("userUid") String userUid, @Param("roomUid") String roomUid);
}
