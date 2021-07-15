package com.example.desafio_quality.utils.mappers;

import com.example.desafio_quality.entities.District;
import com.example.desafio_quality.forms.DistrictForm;
import com.example.desafio_quality.utils.generate.GenerateID;

import java.util.Arrays;

public class DistrictMapper {
    public static District formToEntity (DistrictForm form) {
        return new District(GenerateID.generateIDDistrict(), form.getProp_district(), form.getValue_district_m2());
    }
}
