package com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.Payment;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.Ticket;

public interface PaymentStrategy {
    boolean processPayment(Ticket ticket, double amount);
}
