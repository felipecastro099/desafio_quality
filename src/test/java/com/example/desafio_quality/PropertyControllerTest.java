package com.example.desafio_quality;

import com.example.desafio_quality.entities.District;
import com.example.desafio_quality.entities.Property;
import com.example.desafio_quality.exceptions.NotFoundException;
import com.example.desafio_quality.forms.PropertyForm;
import com.example.desafio_quality.forms.RoomForm;
import com.example.desafio_quality.repositories.DistrictRepository;
import com.example.desafio_quality.repositories.PropertyRepository;
import com.example.desafio_quality.utils.mappers.PropertyMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void init() {
        propertyRepository.removeAll();
        districtRepository.removeAll();
    }

    @Test
    public void shouldSaveProperty() throws Exception {
        String payload = objectMapper.writeValueAsString(returnValidPropertyForm());

        districtRepository.add(new District(1L, "District Test", new BigDecimal("100")));

        mockMvc.perform(post("/properties")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isCreated());
    }

    @Test
    public void ShouldNotSavePropertyIfDistrictNotExists() throws Exception {
        String payload = objectMapper.writeValueAsString(returnNotValidPropertyForm());

        mockMvc.perform(post("/properties")
                .contentType("application/json")
                .content(payload))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof NotFoundException))
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException().getMessage().contains("District not found")));
    }

    @Test
    public void shouldReturnGetTotalPriceProperty() throws Exception {
        Property property = createProperty();

        mockMvc.perform(get("/properties/{id}/totalValue", property.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.totalValue").value(new BigDecimal("10000.0")));
    }

    @Test
    public void shouldReturnGetTotalMetersProperty() throws Exception {
        Property property = createProperty();

        mockMvc.perform(get("/properties/{id}/totalMeters", property.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.totalMeters").value(100.0));
    }

    @Test
    public void shouldReturnBigRoomProperty() throws Exception {
        Property property = createProperty();

        mockMvc.perform(get("/properties/{id}/bigRoom", property.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.bigRoom.name").value("Room"))
                .andExpect(jsonPath("$.bigRoom.width").value(10.0))
                .andExpect(jsonPath("$.bigRoom.length").value(10.0));
    }

    public RoomForm returnRoomForm() {
        return new RoomForm("Room", 10.0, 10.0);
    }

    public List<RoomForm> returnRoomAsList() {
        return Collections.singletonList(returnRoomForm());
    }

    public PropertyForm returnValidPropertyForm() {
        return new PropertyForm("Property", 1L, returnRoomAsList());
    }

    public PropertyForm returnNotValidPropertyForm() {
        return new PropertyForm("Property", 2L, returnRoomAsList());
    }

    public Property createProperty() {
        District district = new District(1L, "District Test", new BigDecimal("100"));
        Property property = PropertyMapper.formToEntity(returnValidPropertyForm(), district);

        propertyRepository.add(property);

        return property;
    }
}
