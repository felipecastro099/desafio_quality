package com.example.desafio_quality.dtos.district;

import java.math.BigDecimal;

public class DistrictDTO {
    private String prop_district;
    private BigDecimal value_district_m2;

    public DistrictDTO(String prop_district, BigDecimal value_district_m2) {
        this.prop_district = prop_district;
        this.value_district_m2 = value_district_m2;
    }

    public String getProp_district() {
        return prop_district;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }
}
