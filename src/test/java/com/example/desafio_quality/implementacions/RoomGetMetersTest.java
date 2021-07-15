package com.example.desafio_quality.implementacions;

import com.example.desafio_quality.entities.Room;
import com.example.desafio_quality.utils.property.TotalPriceProperty;
import com.example.desafio_quality.utils.room.GetMeters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class RoomGetMetersTest {
    private Room room;

    @BeforeEach
    public void init() {
        this.room = new Room(1L, "Room Test", 10.0, 10.0);
    }

    @Test
    public void shouldTotalMeters() {
        Double resultValue = GetMeters.getMeters(this.room);

        Assertions.assertEquals(100.0, resultValue);
    }
}
