package com.example.priyanshuVerma.ParkingLot_SystemDesign.Models;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicBoolean;

@Getter
@Setter
public class ParkingSpot {
    private final String id;

    public ParkingSpot(String id, VehicleType allowedType) {
        this.id = id;
        this.allowedType = allowedType;
    }

    public String getId() {
        return id;
    }

    public VehicleType getAllowedType() {
        return allowedType;
    }

    public AtomicBoolean getOccupied() {
        return occupied;
    }

    public void setOccupied(AtomicBoolean occupied) {
        this.occupied = occupied;
    }

    private final VehicleType allowedType;

    private AtomicBoolean occupied = new AtomicBoolean(false);

    public boolean tryOccupy(){
        return occupied.compareAndSet(false,true);
    }

    public void vacate(){
        occupied.set(false);
    }
    public boolean isOccupied(){
        return occupied.get();
    }



}
