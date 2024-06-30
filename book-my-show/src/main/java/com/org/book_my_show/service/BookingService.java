package com.org.book_my_show.service;

import com.org.book_my_show.models.BookingTicket;

import java.util.List;

public interface BookingService {


    BookingTicket bookMovie(List<Integer> showSeatIds, int showId, int userId) throws Exception;
}
