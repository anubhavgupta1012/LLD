package com.org.parking_lot.models;

import lombok.Data;

@Data
public class Vehicle {
    private String vehicleNumber;
    private int model;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
}
