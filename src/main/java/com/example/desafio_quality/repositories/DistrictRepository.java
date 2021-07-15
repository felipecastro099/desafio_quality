package com.example.desafio_quality.repositories;

import com.example.desafio_quality.entities.District;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DistrictRepository {
    List<District> db = new ArrayList<>();

    public List<District> all() {
        return db;
    }

    public District findByIdOrNull(Long id) {
        Optional<District> result =  db.stream().filter(district -> district.getId() == id).findFirst();

        return result.orElse(null);
    }

    public Boolean exists(Long id) {
        Optional<District> result = Optional.ofNullable(findByIdOrNull(id));

        if (result.isPresent()) {
            return  true;
        }

        return false;
    }

    public void add(District district) {
        db.add(district);
    }

    public void removeAll() { db.removeAll(all()); }
}
