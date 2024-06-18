package com.org.parking_lot.models;

import lombok.Data;

@Data
public class Gate {
    private long id;
    private int gateNumber;
    private Operator operator;

    public Gate(long id, int gateNumber, Operator operator) {
        this.id = id;
        this.gateNumber = gateNumber;
        this.operator = operator;
    }
}
