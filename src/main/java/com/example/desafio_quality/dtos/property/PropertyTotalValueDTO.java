package com.example.desafio_quality.dtos.property;

import java.math.BigDecimal;

public class PropertyTotalValueDTO {
    private String name;
    private BigDecimal totalValue;

    public PropertyTotalValueDTO(String name, BigDecimal totalValue) {
        this.name = name;
        this.totalValue = totalValue;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }
}
