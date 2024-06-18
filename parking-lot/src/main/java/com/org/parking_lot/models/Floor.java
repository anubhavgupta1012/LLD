package com.org.parking_lot.models;

import lombok.Data;

import java.util.List;
@Data
public class Floor {
    private int id;
    private int floorNumber;
    private List<Spot> spots;
}
