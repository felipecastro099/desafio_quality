package com.example.desafio_quality.utils.mappers;
import com.example.desafio_quality.entities.Property;
import com.example.desafio_quality.entities.Room;
import com.example.desafio_quality.forms.PropertyForm;
import com.example.desafio_quality.forms.RoomForm;
import com.example.desafio_quality.utils.generate.GenerateID;

import java.util.ArrayList;
import java.util.List;

public class PropertyMapper {
    public static Property formToEntity(PropertyForm propertyForm) {
        if (propertyForm.getRooms() == null) {
            return new Property(GenerateID.generateIDProperty(), propertyForm.getProp_name(), DistrictMapper.formToEntity(propertyForm.getDistrict()), getListRoom());
        }

        return new Property(GenerateID.generateIDProperty(), propertyForm.getProp_name(), DistrictMapper.formToEntity(propertyForm.getDistrict()), getListRoom(propertyForm.getRooms()));
    }

    public static List<Room> getListRoom() {
        return new ArrayList<>();
    }

    public static List<Room> getListRoom(List<RoomForm> roomFormList) {
        List<Room> rooms = new ArrayList<>();

        roomFormList.forEach(list -> {
            rooms.add(RoomMapper.formToEntity(list));
        });

        return rooms;
    }
}
