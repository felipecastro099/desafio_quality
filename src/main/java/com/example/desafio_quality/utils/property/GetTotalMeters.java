package com.example.desafio_quality.utils.property;

import com.example.desafio_quality.entities.Property;

import java.util.concurrent.atomic.AtomicReference;

public class GetTotalMeters {
    public static Double getTotalMeters(Property property) {
        AtomicReference<Double> totalMeters = new AtomicReference<>(0.0);

        property.getRooms().forEach(room -> {
            totalMeters.updateAndGet(v -> v + (room.getLength() * room.getWidth()));
        });

        return totalMeters.get();
    }
}
