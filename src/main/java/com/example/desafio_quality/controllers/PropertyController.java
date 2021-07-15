package com.example.desafio_quality.controllers;

import com.example.desafio_quality.forms.PropertyForm;
import com.example.desafio_quality.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<?> createProperty(@RequestBody @Valid PropertyForm propertyForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.addProperty(propertyForm));
    }

    @GetMapping("/{id}/totalValue")
    public ResponseEntity<?> createProperty(@PathVariable Long id){
        return ResponseEntity.ok(propertyService.getTotalValue(id));
    }
}
