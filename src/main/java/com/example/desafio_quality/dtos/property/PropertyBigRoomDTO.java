package com.example.desafio_quality.dtos.property;

import com.example.desafio_quality.entities.Room;

public class PropertyBigRoomDTO {
    private String name;
    private Room bigRoom;

    public PropertyBigRoomDTO(String name, Room bigRoom) {
        this.name = name;
        this.bigRoom = bigRoom;
    }

    public String getName() {
        return name;
    }

    public Room getBigRoom() {
        return bigRoom;
    }
}
