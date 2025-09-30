package com.example.priyanshuVerma.ParkingLot_SystemDesign;

import ch.qos.logback.core.subst.Parser;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Factory.PricingStrategyFactory;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Factory.VehicleFactory;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.*;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Services.ParkingLot;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.PricingStrategyType;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.VehicleType;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.PaymentMode;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

@SpringBootApplication
 class Main {
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance();
        EntryGate entryGate = new EntryGate("EG1");
        ExitGate exitGate = new ExitGate("XG1");

        lot.setPricingStrategy(PricingStrategyFactory.get(PricingStrategyType.valueOf("TIME_BASED")));

        ParkingFloor floor1 = new ParkingFloor("Floor1");
        floor1.addSpot(new ParkingSpot("F1S1", VehicleType.BIKE));
        floor1.addSpot(new ParkingSpot("F1S2", VehicleType.CAR));
        floor1.addSpot(new ParkingSpot("F1S3", VehicleType.TRUCK));
        floor1.addSpot(new ParkingSpot("F1S4", VehicleType.CAR));
        lot.addFloor(floor1);

        System.out.println("--------------------------");

//        Vehicle bike1 = VehicleFactory.create("KA01AB1234", VehicleType.BIKE);
//        Vehicle bike2 = VehicleFactory.create("KA01AB5678", VehicleType.TRUCK);
//        LocalDateTime entryTime = DateTimeParser.parse("21 May 7:30 AM 2025");
//        System.out.println(entryTime.truncatedTo(ChronoUnit.HOURS));
//
//        Thread t1 = new Thread(() -> entryGate.parkVehicle(bike1, entryTime));
//        Thread t2 = new Thread(() -> entryGate.parkVehicle(bike2, entryTime));
//
//        t1.start();
//        t2.start();

        Vehicle car = VehicleFactory.create("KA01AB1234", VehicleType.CAR);

        LocalDateTime entryTime1 = DateTimeParser.parse("21 May 7:30 AM 2025");
        Ticket ticket = entryGate.parkVehicle(car, entryTime1);

        System.out.println("--------------------------");

        lot.printStatus();

        System.out.println("--------------------------");

        LocalDateTime exitTime = DateTimeParser.parse("21 May 1:15 PM 2025");
        exitGate.unParkVehicle(ticket.getTicketId(), exitTime, PaymentMode.UPI);

        System.out.println("--------------------------");

        lot.printStatus();
    }
}
