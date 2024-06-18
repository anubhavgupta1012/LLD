package com.org.parking_lot.repository;

import com.org.parking_lot.models.Vehicle;
import com.org.parking_lot.models.VehicleType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class VehicleRepo {

    Map<String, Vehicle> vehicleMap = new HashMap<>();

    public VehicleRepo() {
        vehicleMap.put("HR26EE1111", new Vehicle("HR26EE1111", VehicleType.CAR));
    }

    public Optional<Vehicle> getVehicleByVehicleId(String vehicleId) {
        return Optional.ofNullable(vehicleMap.get(vehicleId));
    }

    public Vehicle save(Vehicle vehicle) {
        vehicleMap.put(String.valueOf(new Random().nextInt()), vehicle);
        return vehicle;
    }
}
