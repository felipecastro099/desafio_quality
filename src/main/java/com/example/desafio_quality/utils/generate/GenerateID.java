package com.example.desafio_quality.utils.generate;

public class GenerateID {
    private static long idProperty = 1L;
    private static long idDistrict = 1L;
    private static long idRoom = 1L;

    public static long generateIDProperty() {
        return idProperty++;
    }

    public static long generateIDDistrict() {
        return idDistrict++;
    }

    public static long generateIDRoom() {
        return idRoom++;
    }
}
