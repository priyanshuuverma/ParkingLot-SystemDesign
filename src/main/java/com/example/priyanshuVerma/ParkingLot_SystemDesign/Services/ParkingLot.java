package com.example.priyanshuVerma.ParkingLot_SystemDesign.Services;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.Factory.PaymentStrategyFactory;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Factory.PricingStrategyFactory;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.ParkingFloor;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.ParkingSpot;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.Ticket;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.Vehicle;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.Payment.PaymentStrategy;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.PricingStrategy;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.PaymentMode;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.PricingStrategyType;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class ParkingLot {
    private static final ParkingLot INSTANCE = new ParkingLot();

    private final Map<String, ParkingFloor> floors = new HashMap<>();
    private final Map<String, Ticket> activeTickets = new HashMap<>();

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    private PricingStrategy pricingStrategy;

    private ParkingLot() {
        this.pricingStrategy = PricingStrategyFactory.get(PricingStrategyType.TIME_BASED);
    }

    public static ParkingLot getInstance() {
        return INSTANCE;
    }

    public void addFloor(ParkingFloor floor) {
        floors.put(floor.getId(), floor);
    }

    // b1, b2 (one spot)
    // car, bike

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime) {
        for (ParkingFloor floor : floors.values()) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle.getType());

            if (spot != null) {
                // Successfully reserved the spot via atomic operation
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = new Ticket.Builder()
                        .ticketId(ticketId)
                        .entryTime(entryTime)
                        .vehicle(vehicle)
                        .floorId(floor.getId())
                        .spotId(spot.getId())
                        .build();

                activeTickets.put(ticketId, ticket);
                System.out.println("Vehicle parked. Ticket: " + ticketId);
                return ticket;
            }
        }

        System.out.println("No spot available for vehicle type: " + vehicle.getType());
        return null;
    }

    public void unparkVehicle(String ticketId, LocalDateTime exitTime, PaymentMode paymentMode) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            System.out.println("Invalid ticket ID.");
            return;
        }

        double fee = pricingStrategy.calculateFee(
                ticket.getVehicle().getType(),
                ticket.getEntryTime(),
                exitTime
        );

        PaymentStrategy strategy = PaymentStrategyFactory.get(paymentMode);
        PaymentProcess processor = new PaymentProcess(strategy);
        boolean paid = processor.pay(ticket, fee);

        if (!paid) {
            System.out.println("Vehicle cannot exit. Payment unsuccessful.");
            return;
        }

        ParkingSpot spot = floors.get(ticket.getFloorId()).getSpots().get(ticket.getSpotId());
        spot.vacate();
        activeTickets.remove(ticketId);

        System.out.println("Vehicle exited. Fee charged: ₹" + fee);
    }

    public void printStatus() {
        floors.forEach((floorId, floor) -> {
            System.out.println("Floor: " + floorId);
            floor.getSpots().values().forEach(spot -> {
                System.out.println(" Spot " + spot.getId() + " [" + spot.getAllowedType() + "] - " + (spot.isOccupied() ? "Occupied" : "Free"));
            });
        });
    }
}