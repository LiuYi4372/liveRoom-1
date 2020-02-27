package com.anzi.service.Impl;

import com.anzi.mapper.RoomMapper;
import com.anzi.pojo.Room;
import com.anzi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;


    @Override
    public List<Room> listRoom() {
        return roomMapper.listRoom();
    }


}
