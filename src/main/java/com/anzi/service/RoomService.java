package com.anzi.service;

import com.anzi.pojo.Room;
import com.anzi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomService {
    List<Room> listRoom();
}
