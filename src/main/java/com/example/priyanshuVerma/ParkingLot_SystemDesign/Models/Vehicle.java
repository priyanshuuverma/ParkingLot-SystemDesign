package com.example.priyanshuVerma.ParkingLot_SystemDesign.Models;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.VehicleType;
import lombok.RequiredArgsConstructor;

public abstract class Vehicle {
    private final String number;

    public VehicleType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    private final VehicleType type;

    protected Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }
}
