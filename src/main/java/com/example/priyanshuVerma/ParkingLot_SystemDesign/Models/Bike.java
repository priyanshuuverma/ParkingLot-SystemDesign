package com.example.priyanshuVerma.ParkingLot_SystemDesign.Models;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.VehicleType;

public class Bike extends Vehicle{

    public Bike(String number) {
        super(number, VehicleType.BIKE);
    }
}
