package com.example.desafio_quality.services;

import com.example.desafio_quality.dtos.property.PropertyBigRoomDTO;
import com.example.desafio_quality.dtos.property.PropertyDTO;
import com.example.desafio_quality.dtos.property.PropertyTotalMetersDTO;
import com.example.desafio_quality.dtos.property.PropertyTotalValueDTO;
import com.example.desafio_quality.entities.Property;
import com.example.desafio_quality.exceptions.NotFoundException;
import com.example.desafio_quality.forms.PropertyForm;
import com.example.desafio_quality.repositories.DistrictRepository;
import com.example.desafio_quality.repositories.PropertyRepository;
import com.example.desafio_quality.utils.mappers.PropertyMapper;
import com.example.desafio_quality.utils.property.GetBigRoomProperty;
import com.example.desafio_quality.utils.property.GetTotalMeters;
import com.example.desafio_quality.utils.property.TotalPriceProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    public PropertyDTO addProperty(PropertyForm propertyForm) {
        if (districtRepository.exists(propertyForm.getDistrict().getProp_district(), propertyForm.getDistrict().getValue_district_m2())) {
            System.out.println(propertyForm.getRooms());
            Property property = PropertyMapper.formToEntity(propertyForm);

            propertyRepository.add(property);

            return new PropertyDTO(property.getName(), property.getDistrict(), property.getRooms());
        }

        throw new NotFoundException("District not found");
    }

    public PropertyTotalValueDTO getTotalValue(long id) {
        Property property = propertyRepository.findByIdOrNull(id);

        if (property != null) {
            return new PropertyTotalValueDTO(property.getName(), TotalPriceProperty.totalPrice(property));
        }

        throw new NotFoundException("Property not found");
    }

    public PropertyTotalMetersDTO getTotalMeters(long id) {
        Property property = propertyRepository.findByIdOrNull(id);

        if (property != null) {
            return new PropertyTotalMetersDTO(property.getName(), GetTotalMeters.getTotalMeters(property));
        }

        throw new NotFoundException("Property not found");
    }

    public PropertyBigRoomDTO getBigRoom(long id) {
        Property property = propertyRepository.findByIdOrNull(id);

        if (property != null) {
            return new PropertyBigRoomDTO(property.getName(), GetBigRoomProperty.getBigRoomProperty(property));
        }

        throw new NotFoundException("Property not found");
    }
}
