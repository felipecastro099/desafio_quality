package com.example.desafio_quality.services;

import com.example.desafio_quality.dtos.district.DistrictDTO;
import com.example.desafio_quality.entities.District;
import com.example.desafio_quality.forms.DistrictForm;
import com.example.desafio_quality.repositories.DistrictRepository;
import com.example.desafio_quality.utils.mappers.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public DistrictDTO addDistrict(DistrictForm districtForm) {
        District district = DistrictMapper.formToEntity(districtForm);
        districtRepository.add(district);

        return new DistrictDTO(district.getId(), district.getName(), district.getValue());
    }
}
