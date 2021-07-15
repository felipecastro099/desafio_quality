package com.example.desafio_quality.forms;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class DistrictForm {
    @NotNull(message = "can not be null")
    @NotEmpty(message = "can not be empty")
    @Size(max = 45, message = "can't be more than 45 characters")
    private String prop_district;
    @NotNull(message = "can not be null")
    @DecimalMax(value = "9999999999.999", message = "can't be more than 13 digits")
    private BigDecimal value_district_m2;

    public DistrictForm(String prop_district, BigDecimal value_district_m2) {
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
