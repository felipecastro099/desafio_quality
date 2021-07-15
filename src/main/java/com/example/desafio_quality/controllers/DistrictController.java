package com.example.desafio_quality.controllers;

import com.example.desafio_quality.forms.DistrictForm;
import com.example.desafio_quality.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<?> createDistrict(@RequestBody @Valid DistrictForm propertyForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(districtService.addDistrict(propertyForm));
    }
}
