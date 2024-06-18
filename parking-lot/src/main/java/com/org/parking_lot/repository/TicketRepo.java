package com.org.parking_lot.repository;

import com.org.parking_lot.models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TicketRepo {
    Map<Long, Ticket> ticketMap = new HashMap<>();

    public Ticket save(Ticket ticket) {
        ticketMap.put(new Random().nextLong(), ticket);
        return ticket;
    }
}
