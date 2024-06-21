package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
public class Payment {
    @Id
    private int id;
    private int amount;
    private String mode;
    private String comments;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;
}
