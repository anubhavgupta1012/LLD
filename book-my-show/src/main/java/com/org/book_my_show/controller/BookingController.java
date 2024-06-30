package com.org.book_my_show.controller;

import com.org.book_my_show.dto.MovieRequest;
import com.org.book_my_show.dto.MovieResponse;
import com.org.book_my_show.models.BookingTicket;
import com.org.book_my_show.models.ResponseStatus;
import com.org.book_my_show.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @Autowired
    private BookingService service;


    @PostMapping("/movie")
    public ResponseEntity<MovieResponse> bookMovieTicket(MovieRequest movieRequest) {
        BookingTicket bookingTicket = null;
        try {
            bookingTicket = service.bookMovie(movieRequest.getShowSeatIds(), movieRequest.getShowId(), movieRequest.getUserId());

            MovieResponse response = MovieResponse.builder()
                    .responseStatus(ResponseStatus.SUCCESS)
                    .bookingId(bookingTicket.getTicketId())
                    .userId(bookingTicket.getUser().getId())
                    .showId(bookingTicket.getShow().getShowId())
                    .amount(bookingTicket.getTotalPrice())
                    .showSeatIds(bookingTicket.getShowSeats())
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(MovieResponse.builder().responseStatus(ResponseStatus.FAILURE).build());
        }
    }
}
