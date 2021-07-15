package com.example.desafio_quality.utils.mappers;

import com.example.desafio_quality.entities.Room;
import com.example.desafio_quality.forms.RoomForm;
import com.example.desafio_quality.utils.generate.GenerateID;

public class RoomMapper {
    public static Room formToEntity(RoomForm roomForm) {
        return new Room(GenerateID.generateIDRoom(), roomForm.getRoom_name(), roomForm.getRoom_width(), roomForm.getRoom_length());
    }
}
