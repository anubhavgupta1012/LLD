package com.org.parking_lot.repository;

import com.org.parking_lot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepo {

    Map<String, ParkingLot> parkingLotMap = new HashMap<>();

    public ParkingLot getParkingLotById(String id) {
        return parkingLotMap.get(id);
    }
}
