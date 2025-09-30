package com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.Payment;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.Ticket;

public class UpiPayment implements PaymentStrategy{
    @Override
    public boolean processPayment(Ticket ticket, double amount) {
        System.out.println("Paid Rup:" + amount + "for ticket" + ticket.getTicketId()+ "via Upi");
        return true;
    }
}
