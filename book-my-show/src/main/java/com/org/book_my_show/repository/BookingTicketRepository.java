package com.org.book_my_show.repository;

import com.org.book_my_show.models.BookingTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingTicketRepository extends JpaRepository<BookingTicket, Integer> {


    BookingTicket findByTicketId(Integer ticketId);
}