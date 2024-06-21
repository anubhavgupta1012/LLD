package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    private int id;
    private String name;
    private String email;
    @OneToMany
    private List<BookingTicket> bookingTickets;
}
