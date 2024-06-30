package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class ShowSeatType {
    // this entity represents Mapping in between show & SeatType
    @Id
    private int ShowSeatTypeId;
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private int price;
}
