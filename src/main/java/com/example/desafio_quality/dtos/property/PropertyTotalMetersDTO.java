package com.example.desafio_quality.dtos.property;

public class PropertyTotalMetersDTO {
    private String name;
    private Double totalMeters;

    public PropertyTotalMetersDTO(String name, Double totalMeters) {
        this.name = name;
        this.totalMeters = totalMeters;
    }

    public String getName() {
        return name;
    }

    public Double getTotalMeters() {
        return totalMeters;
    }
}
