package com.example.priyanshuVerma.ParkingLot_SystemDesign.Factory;

import com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.PricingStrategy;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.Strategy.TimeBasedPricing;
import com.example.priyanshuVerma.ParkingLot_SystemDesign.enums.PricingStrategyType;

public class PricingStrategyFactory {
    public static PricingStrategy get(PricingStrategyType type){
        return switch (type) {
            case TIME_BASED -> new TimeBasedPricing();
            case EVENT_BASED -> new TimeBasedPricing();
        };
    }
}
