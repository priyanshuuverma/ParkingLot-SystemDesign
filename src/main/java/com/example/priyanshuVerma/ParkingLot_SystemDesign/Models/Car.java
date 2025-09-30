package com.example.priyanshuVerma.ParkingLot_SystemDesign.Models;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.VehicleType;

public class Car extends Vehicle{
    public Car(String number){
        super(number, VehicleType.CAR);
    }
}
