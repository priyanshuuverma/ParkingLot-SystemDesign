package com.example.priyanshuVerma.ParkingLot_SystemDesign.Models;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.Services.ParkingLot;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.GateType;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.PaymentMode;

import java.time.LocalDateTime;

public class ExitGate extends Gate{

    public ExitGate(String id) {
        super(id);
    }

    @Override
    public GateType getType()
    {
        return GateType.EXIT;
    }

    public void unParkVehicle(String ticketID, LocalDateTime exitTime, PaymentMode paymentMode){
        ParkingLot.getInstance().unparkVehicle(ticketID,exitTime,paymentMode);
    }
}
