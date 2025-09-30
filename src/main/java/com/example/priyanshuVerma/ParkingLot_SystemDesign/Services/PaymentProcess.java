package com.example.priyanshuVerma.ParkingLot_SystemDesign.Services;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.Models.Ticket;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.Payment.PaymentStrategy;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.PaymentStatus;

public class PaymentProcess {
    public final PaymentStrategy strategy;

    public PaymentProcess(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public boolean pay(Ticket ticket, double amount){
        boolean success = strategy.processPayment( ticket ,amount);
        if(success){
            ticket.setPaymentStatus(PaymentStatus.SUCCESS);
        } else{
            ticket.setPaymentStatus(PaymentStatus.FAILED);
            System.out.println("Payment is failed for the ticket" + ticket.getTicketId());
        }
        return success;
    }

}
