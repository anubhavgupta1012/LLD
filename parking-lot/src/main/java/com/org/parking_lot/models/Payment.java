package com.org.parking_lot.models;

import lombok.Data;

@Data
public class Payment {
    private int id;
    private PaymentMode mode;
    private int amount;
}
