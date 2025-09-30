package com.example.priyanshuVerma.ParkingLot_SystemDesign.Models;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Ticket {

    private String ticketId;
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private String floorId;
    private String spotId;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;


    private Ticket(Builder builder) {
        this.ticketId = builder.ticketId;
        this.entryTime = builder.entryTime;
        this.vehicle = builder.vehicle;
        this.floorId = builder.floorId;
        this.spotId = builder.spotId;
        this.paymentStatus = builder.paymentStatus;
    }
 
    public static class Builder {
        private String ticketId;
        private LocalDateTime entryTime;
        private Vehicle vehicle;
        private String floorId;
        private String spotId;
        private PaymentStatus paymentStatus = PaymentStatus.PENDING;

        public Builder ticketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public Builder entryTime(LocalDateTime entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public Builder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder floorId(String floorId) {
            this.floorId = floorId;
            return this;
        }

        public Builder spotId(String spotId) {
            this.spotId = spotId;
            return this;
        }

        public Builder paymentStatus(PaymentStatus paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
