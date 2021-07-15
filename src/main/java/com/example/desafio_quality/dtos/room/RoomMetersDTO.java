package com.example.desafio_quality.dtos.room;

public class RoomMetersDTO {
    private Long id;
    private String name;
    private Double width;
    private Double length;
    private Double totalMeters;

    public RoomMetersDTO(Long id, String name, Double width, Double length, Double totalMeters) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.length = length;
        this.totalMeters = totalMeters;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getWidth() {
        return width;
    }

    public Double getLength() {
        return length;
    }

    public Double getTotalMeters() {
        return totalMeters;
    }
}
