package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Seat {
    @Id
    private String seatId;
    private String seatNumber;
    @ManyToOne
    private SeatType seatType;
    private int rowVal;
    private int colVal;         /*row and col are special keyword that is not to be used*/
}
