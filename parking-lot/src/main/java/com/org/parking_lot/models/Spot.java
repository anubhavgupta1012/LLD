package com.org.parking_lot.models;

import lombok.Data;

@Data
public class Spot {
    private int spotId;
    private int spotNumber;
    private Floor floor;
    private VehicleType type;
    private SpotStatus spotStatus;

}
