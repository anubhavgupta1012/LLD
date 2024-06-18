package com.org.parking_lot.models;

import lombok.Data;

import java.util.Date;

@Data
public class Ticket {
    private int id;
    private Date entryTime;
    private Vehicle vehicle;
    private Gate gate;
    private Operator operator;
    private Spot spot;
}
