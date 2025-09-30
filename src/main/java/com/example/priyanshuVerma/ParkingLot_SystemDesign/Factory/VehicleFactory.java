package com.example.priyanshuVerma.ParkingLot_SystemDesign.Factory;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.Bike;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.Car;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.Truck;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.Vehicle;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.VehicleType;

public class VehicleFactory {
    public static Vehicle create(String number, VehicleType type){
        return switch (type)
        {
            case CAR -> new Car(number);
            case BIKE -> new Bike(number);
            case TRUCK -> new Truck(number);
        };
    }
}
