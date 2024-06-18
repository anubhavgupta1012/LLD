package com.org.parking_lot.strategy;

import com.org.parking_lot.models.*;

import java.util.List;

public class RandomAllotmentStrategy implements AllotmentStrategy {
    @Override
    public Spot getSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        List<Floor> floors = parkingLot.getFloors();
        for (Floor floor : floors) {
            List<Spot> spots = floor.getSpots();
            for (Spot spot : spots) {
                if (vehicleType.equals(spot.getType()) && SpotStatus.EMPTY.equals(spot.getSpotStatus())) {
                    return spot;
                }
            }
        }
        return null;
    }
}
