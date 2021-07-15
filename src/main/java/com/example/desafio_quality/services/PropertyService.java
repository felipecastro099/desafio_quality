package com.example.desafio_quality.services;

import com.example.desafio_quality.dtos.property.PropertyDTO;
import com.example.desafio_quality.entities.Property;
import com.example.desafio_quality.exceptions.NotFoundException;
import com.example.desafio_quality.forms.PropertyForm;
import com.example.desafio_quality.repositories.DistrictRepository;
import com.example.desafio_quality.repositories.PropertyRepository;
import com.example.desafio_quality.utils.mappers.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    public PropertyDTO addProperty(PropertyForm propertyForm) {
        if (!districtRepository.exists(propertyForm.getDistrict().getProp_district(), propertyForm.getDistrict().getValue_district_m2())) {
            System.out.println(propertyForm.getRooms());
            Property property = PropertyMapper.formToEntity(propertyForm);

            propertyRepository.add(property);

            return new PropertyDTO(property.getName(), property.getDistrict(), property.getRooms());
        }

        throw new NotFoundException("District not found");
    }
}
