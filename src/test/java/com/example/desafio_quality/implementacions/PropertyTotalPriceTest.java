package com.example.desafio_quality.implementacions;

import com.example.desafio_quality.entities.District;
import com.example.desafio_quality.entities.Property;
import com.example.desafio_quality.entities.Room;
import com.example.desafio_quality.utils.property.TotalPriceProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest
public class PropertyTotalPriceTest {
    private District district;
    private Property property;

    @BeforeEach
    public void init() {
        this.district = new District(1L, "District Teste", BigDecimal.valueOf(10.0));
        this.property= new Property(1L, "Property Teste", this.district, new ArrayList<>());
    }

    @Test
    public void shouldTotalPriceEqualsZero() {
        BigDecimal resultValue = TotalPriceProperty.totalPrice(this.property);

        Assertions.assertEquals(new BigDecimal("0.00"), resultValue);
    }


    @Test
    public void shouldTotalPriceEqualsMultiplyRoomMeters() {
        Room roomOne = new Room(1L, "Room Test", 10.0, 10.0);
        Room roomTwo = new Room(1L, "Room Test", 11.0, 10.0);

        this.property.getRooms().add(roomOne);
        this.property.getRooms().add(roomTwo);

        BigDecimal resultValue = TotalPriceProperty.totalPrice(this.property);

        Assertions.assertEquals(new BigDecimal("2100.00"), resultValue);
    }
}
