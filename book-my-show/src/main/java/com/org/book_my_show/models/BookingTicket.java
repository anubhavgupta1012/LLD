package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class BookingTicket {
    @Id
    private int ticketId;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User user;
    private int totalPrice;
    @ManyToOne
    private Show show;
    @OneToMany
    List<Payment> payments;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private Date bookingTime;
}
