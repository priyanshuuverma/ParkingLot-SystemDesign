package com.example.priyanshuVerma.ParkingLot_SystemDesign.Factory;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.Payment.CardPayment;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.Payment.CashPayment;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.Payment.PaymentStrategy;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.Payment.UpiPayment;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.PaymentMode;

public class PaymentStrategyFactory {
    public static PaymentStrategy get(PaymentMode mode){
        return switch (mode){
            case UPI -> new UpiPayment();
            case CARD -> new CardPayment();
            case CASH -> new CashPayment();
        };
    }
}
