package com.org.book_my_show.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SeatType {
    @Id
    private int id;
    private String name;
}
