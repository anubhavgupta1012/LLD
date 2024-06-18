package com.org.parking_lot.models;

import lombok.Data;

@Data
public class Operator {
    private int id;
    private int empId;
    private String name;

    public Operator(int id, int empId, String name) {
        this.id = id;
        this.empId = empId;
        this.name = name;
    }
}
