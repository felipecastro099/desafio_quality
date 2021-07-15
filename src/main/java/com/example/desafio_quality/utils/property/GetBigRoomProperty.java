package com.example.desafio_quality.utils.property;

import com.example.desafio_quality.entities.Property;
import com.example.desafio_quality.entities.Room;

public class GetBigRoomProperty {
    public static Room getBigRoomProperty(Property property) {
        Double meters = 0.0;
        Room bigRoom = null;

        for (Room room: property.getRooms()) {
            Double value = room.getWidth() * room.getLength();
            if (meters <= value) {
                meters = value;
                bigRoom = room;
            }
        }

        return bigRoom;
    }
}
