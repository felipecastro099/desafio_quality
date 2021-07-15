package com.example.desafio_quality.repositories;

import com.example.desafio_quality.entities.Property;
import com.example.desafio_quality.entities.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PropertyRepository {
    private List<Property> db = new ArrayList<>();

    public List<Property> all() {
        return db;
    }

    public void add(Property property) {
        db.add(property);
    }

    public Property findByIdOrNull(Long id) {
        Optional<Property> result = db.stream().filter(property -> property.getId().equals(id)).findFirst();

        return result.orElse(null);
    }

    public void addRoomInProperty(Property property, Room room) {
        property.getRooms().add(room);
    }

    public void removeAll() { db.removeAll(all()); }
}
