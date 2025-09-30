package com.example.priyanshuVerma.ParkingLot_SystemDesign.Models;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.VehicleType;

public class Truck extends Vehicle{
    public Truck(String number){
        super(number, VehicleType.TRUCK);
    }
}
