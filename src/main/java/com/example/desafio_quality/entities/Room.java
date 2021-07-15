package com.example.desafio_quality.entities;

public class Room {
    private Long id;
    private String name;
    private Double width;
    private Double length;

    public Room(Long id, String name, Double width, Double length) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.length = length;
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

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
