package com.example.desafio_quality.dtos.property;

import com.example.desafio_quality.entities.District;
import com.example.desafio_quality.entities.Room;

import java.util.List;

public class PropertyDTO {
    private String name;
    private District district;
    private List<Room> room;

    public PropertyDTO(String name, District district, List<Room> room) {
        this.name = name;
        this.district = district;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public District getDistrict() {
        return district;
    }

    public List<Room> getRoom() {
        return room;
    }
}
