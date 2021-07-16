package com.example.desafio_quality.implementacions;

import com.example.desafio_quality.entities.District;
import com.example.desafio_quality.entities.Property;
import com.example.desafio_quality.entities.Room;
import com.example.desafio_quality.utils.property.GetBigRoomProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest
public class PropertyBigRoomTest {

    private District district;
    private Property property;

    @BeforeEach
    public void init() {
        this.district = new District(1L, "District Teste", BigDecimal.valueOf(10.0));
        this.property= new Property(1L, "Property Teste", this.district, new ArrayList<>());
    }

    @Test
    public void shouldBigRoomEqualsNull() {
        Room resultValue = GetBigRoomProperty.getBigRoomProperty(this.property);

        Assertions.assertNull(resultValue);
    }

    @Test
    public void shouldBigRoomEqualsRoomObject() {
        Room room = new Room(1L, "Room Test", 10.0, 10.0);

        this.property.getRooms().add(room);

        Room expectRoom = GetBigRoomProperty.getBigRoomProperty(this.property);

        Assertions.assertEquals(expectRoom, room);
    }

    @Test
    public void shouldBigRoomEqualsBigRoomObject() {
        Room roomSmaller = new Room(1L, "Room Test", 10.0, 10.0);
        Room roomBigger = new Room(1L, "Room Test", 11.0, 10.0);

        this.property.getRooms().add(roomSmaller);
        this.property.getRooms().add(roomBigger);

        Room expectRoom = GetBigRoomProperty.getBigRoomProperty(this.property);

        Assertions.assertEquals(expectRoom, roomBigger);
    }
}
