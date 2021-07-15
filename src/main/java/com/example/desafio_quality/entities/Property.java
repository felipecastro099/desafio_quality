package com.example.desafio_quality.entities;

import java.util.List;

public class Property {
    private Long id;
    private String name;
    private District district;
    private List<Room> rooms;

    public Property(Long id, String name, District district, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
