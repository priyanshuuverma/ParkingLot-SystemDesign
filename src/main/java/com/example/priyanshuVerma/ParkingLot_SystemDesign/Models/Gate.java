package com.example.priyanshuVerma.ParkingLot_SystemDesign.Models;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.GateType;

public abstract class Gate {
    protected final String id;

    protected Gate(String id) {
        this.id = id;
    }

    public abstract GateType getType();
}
