package com.example.desafio_quality.implementacions;

import com.example.desafio_quality.entities.District;
import com.example.desafio_quality.entities.Property;
import com.example.desafio_quality.entities.Room;
import com.example.desafio_quality.repositories.DistrictRepository;
import com.example.desafio_quality.repositories.PropertyRepository;
import com.example.desafio_quality.utils.property.GetTotalMeters;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest
public class PropertyTotalMetersTest {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    private District district;
    private Property property;

    @BeforeEach
    public void init() {
        this.district = new District(1L, "District Teste", BigDecimal.valueOf(10.0));
        this.property= new Property(1L, "Property Teste", this.district, new ArrayList<>());

        districtRepository.add(this.district);
        propertyRepository.add(this.property);
    }

    @AfterEach
    public void finish() {
        districtRepository.removeAll();
        propertyRepository.removeAll();
    }

    @Test
    public void shouldTotalMetersTestEqualsZero() {
        Double expectValue = 0.0;

        Double resultValue = GetTotalMeters.getTotalMeters(this.property);

        Assertions.assertEquals(expectValue, resultValue);
    }

    @Test
    public void shouldTotalMetersTestDiffZero() {
        Double expectValue = 100.0;

        Room room = new Room(1L, "Room Test", 10.0, 10.0);

        this.property.getRooms().add(room);

        Double resultValue = GetTotalMeters.getTotalMeters(this.property);

        Assertions.assertEquals(expectValue, resultValue);
    }
}
