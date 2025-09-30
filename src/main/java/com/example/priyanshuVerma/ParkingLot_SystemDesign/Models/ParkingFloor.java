package com.example.priyanshuVerma.ParkingLot_SystemDesign.Models;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    public ParkingFloor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Map<String, ParkingSpot> getSpots() {
        return spots;
    }

    private final String id;
    private final Map<String, ParkingSpot> spots = new HashMap<>();

    public void addSpot(ParkingSpot spot){
        spots.put(spot.getId(), spot);
    }

    public ParkingSpot findAvailableSpot(VehicleType type){
        for(ParkingSpot spot : spots.values()){
            if(spot.getAllowedType() == type && spot.tryOccupy()){
                return spot;
            }
        }
        return null;
    }
}
