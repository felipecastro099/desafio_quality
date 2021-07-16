package com.example.desafio_quality;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.desafio_quality.forms.DistrictForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

@AutoConfigureMockMvc
@SpringBootTest
public class DistrictControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldSaveDistrict() throws Exception {
        DistrictForm districtForm = new DistrictForm("District Test", new BigDecimal("100"));

        String payload = objectMapper.writeValueAsString(districtForm);

        mockMvc.perform(post("/districts")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isCreated());
    }
}
