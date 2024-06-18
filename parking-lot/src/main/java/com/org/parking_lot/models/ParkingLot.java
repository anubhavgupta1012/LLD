package com.org.parking_lot.models;

import lombok.Data;

import java.util.List;

@Data
public class ParkingLot {
    private int id;
    private List<Floor> floors;
    private List<Gate> gates;
    private String location;
    private List<VehicleType> vehicleTypes;
    private AllotmentStrategyType allotmentStrategyType;
    private FeeCalculationStrategy feeCalculationStrategy;
}
