package com.org.parking_lot.strategy;

import com.org.parking_lot.models.AllotmentStrategyType;

public class SpotAssignmentStrategyFactory {

    public static AllotmentStrategy getSpotAssignmentStrategy(AllotmentStrategyType allotmentStrategyType) {
        return new RandomAllotmentStrategy();
    }
}
