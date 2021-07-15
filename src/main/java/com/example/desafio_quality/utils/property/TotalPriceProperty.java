package com.example.desafio_quality.utils.property;

import com.example.desafio_quality.entities.Property;

import java.math.BigDecimal;

public class TotalPriceProperty {
    public static BigDecimal totalPrice(Property property) {
        BigDecimal value = property.getDistrict().getValue();
        Double totalMeters = GetTotalMeters.getTotalMeters(property);

        return value.multiply(BigDecimal.valueOf(totalMeters));
    }
}
