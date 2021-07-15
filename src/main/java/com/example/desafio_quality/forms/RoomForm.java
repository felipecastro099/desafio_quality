package com.example.desafio_quality.forms;

import javax.validation.constraints.*;

public class RoomForm {
    @NotNull(message = "can not be null")
    @NotEmpty(message = "can not be empty")
    @Pattern(regexp = "^[A-Z]\\w+", message = "first letter must be capital")
    @Size(max = 30, message = "can't be more than 30 characters")
    private String room_name;
    @NotNull(message = "can not be null")
    @Max(value = 25, message = "maximum width is 25 meters")
    private Double room_width;
    @NotNull(message = "can not be null")
    @Max(value = 25, message = "maximum width is 25 meters")
    private Double room_length;

    public RoomForm(String room_name, Double room_width, Double room_length) {
        this.room_name = room_name;
        this.room_width = room_width;
        this.room_length = room_length;
    }

    public String getRoom_name() {
        return room_name;
    }

    public Double getRoom_width() {
        return room_width;
    }

    public Double getRoom_length() {
        return room_length;
    }
}
