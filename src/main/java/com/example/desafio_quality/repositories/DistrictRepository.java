package com.example.desafio_quality.repositories;

import com.example.desafio_quality.entities.District;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DistrictRepository {
    List<District> db = new ArrayList<>();

    public Boolean exists(String name, BigDecimal value) {
        for (District district: db) {
            if (district.getName().equals(name) && district.getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    public void add(District district) {
        db.add(district);
    }
}
