package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ShowSeat {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "showId")
    private Show show;
    @ManyToOne
    @JoinColumn(name = "seatId")
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private SeatShowStatus seatShowStatus;
    private int price;
}
