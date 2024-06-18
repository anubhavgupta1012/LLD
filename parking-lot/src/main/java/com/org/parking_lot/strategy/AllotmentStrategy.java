package com.org.parking_lot.strategy;

import com.org.parking_lot.models.ParkingLot;
import com.org.parking_lot.models.Spot;
import com.org.parking_lot.models.VehicleType;

public interface AllotmentStrategy {

    public Spot getSpot(ParkingLot parkingLot, VehicleType vehicleType);
}
