package com.example.desafio_quality.forms;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class PropertyForm {
    @NotNull(message = "can not be null")
    @NotEmpty(message = "can not be empty")
    @Pattern(regexp = "^[A-Z]\\w+", message = "first letter must be capital")
    @Size(max = 30, message = "can't be more than 30 characters")
    private String prop_name;
    @Valid
    @NotNull(message = "can not be null")
    private Long district;
    @Valid
    private List<RoomForm> rooms;

    public PropertyForm(String prop_name, Long district, List<RoomForm> rooms) {
        this.prop_name = prop_name;
        this.district = district;
        this.rooms = rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public Long getDistrict() {
        return district;
    }

    public List<RoomForm> getRooms() {
        return rooms;
    }
}
