package com.example.desafio_quality.utils.room;

import com.example.desafio_quality.entities.Room;

public class GetMeters {
    public static Double getMeters(Room room) {
        return room.getLength() * room.getLength();
    }
}
