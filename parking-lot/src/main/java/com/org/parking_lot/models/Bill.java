package com.org.parking_lot.models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Bill {
    private int id;
    private Ticket ticket;
    private Timestamp exitTime;
    private FeeCalculationStrategy feeCalculationStrategy;
    private Gate exitGate;
    private int totalFee;
    private Payment payment;
}
