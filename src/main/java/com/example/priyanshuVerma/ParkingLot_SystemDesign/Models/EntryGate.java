package com.example.priyanshuVerma.ParkingLot_SystemDesign.Models;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.Services.ParkingLot;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.GateType;

import java.time.LocalDateTime;

public class EntryGate extends Gate{
    public EntryGate(String id){
        super(id);
    }

    @Override
    public GateType getType(){
        return GateType.ENTRY;
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){
        return ParkingLot.getInstance().parkVehicle(vehicle, entryTime);
    }
}
