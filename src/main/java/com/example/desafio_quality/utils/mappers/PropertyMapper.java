package com.example.desafio_quality.utils.mappers;
import com.example.desafio_quality.entities.Property;
import com.example.desafio_quality.forms.PropertyForm;
import com.example.desafio_quality.utils.generate.GenerateID;

public class PropertyMapper {
    public static Property formToEntity(PropertyForm propertyForm) {
        return new Property(GenerateID.generateIDProperty(), propertyForm.getProp_name(), DistrictMapper.formToEntity(propertyForm.getDistrict()));
    }
}
