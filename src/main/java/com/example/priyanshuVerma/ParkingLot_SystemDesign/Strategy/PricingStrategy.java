package com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.VehicleType;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculateFee(VehicleType type, LocalDateTime entryTime, LocalDateTime exitTime);
}
