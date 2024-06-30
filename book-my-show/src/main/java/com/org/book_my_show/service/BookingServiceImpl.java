package com.org.book_my_show.service;

import com.org.book_my_show.models.*;
import com.org.book_my_show.repository.BookingTicketRepository;
import com.org.book_my_show.repository.ShowRepository;
import com.org.book_my_show.repository.ShowSeatRepository;
import com.org.book_my_show.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private PriceCalculatorService priceCalculatorService;
    @Autowired
    private BookingTicketRepository bookingTicketRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public BookingTicket bookMovie(List<Integer> showSeatIds, int showId, int userId) throws Exception {

        /*
         *   1. Get User from the DB using userId (Validate)
         *   2. Get Show from the db using showId (Validate)
         *   3. init a DB transaction
         *   4. Get showSeat from db using ShowSeatIds
         *   5. Check if they are available, if Not throw error, else update the status to BLOCKED
         *   6. Save to DB
         *   7. End of DB Transaction
         *
         *   8. Create a BookingTicket Object and Return to the controller
         *
         *
         *   In this example Start of Transaction will start from 1 and end on 8 and will be governed by @Transactional
         */

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new Exception("User not found");
        }
        User user = userOptional.get();

        Optional<Show> showOptional = showRepository.findById(showId);
        if (showOptional.isEmpty()) throw new Exception("Show not found");

        Show show = showOptional.get();


        List<ShowSeat> allSeatsByIds = showSeatRepository.findAllById(showSeatIds);
        if (allSeatsByIds.size() != showSeatIds.size()) {
            throw new Exception("all Selected seats not found");
        }

        for (ShowSeat seat : allSeatsByIds) {
            /* Either Seat is Available or if Seat is blocked and Duration of being blocked is GT 15 min*/
            if (!(SeatShowStatus.EMPTY.equals(seat.getSeatShowStatus()) || (SeatShowStatus.BLOCKED.equals(seat.getSeatShowStatus()) && Duration.between(seat.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes() > 15))) {
                throw new Exception("Seats are not Available");
            }
        }
        Date date = new Date();
        for (ShowSeat seat : allSeatsByIds) {
            seat.setSeatShowStatus(SeatShowStatus.BOOKED);
            seat.setBlockedAt(date);
        }
        List<ShowSeat> showSeats = showSeatRepository.saveAll(allSeatsByIds);

        BookingTicket bookingTicket = new BookingTicket();
        bookingTicket.setShowSeats(showSeats);
        bookingTicket.setUser(user);
        bookingTicket.setBookingStatus(BookingStatus.PENDING);
        //bookingTicket.setBookingTime(date);
        bookingTicket.setShow(show);
        bookingTicket.setTotalPrice(priceCalculatorService.calculatePriceForShow(show, showSeats));
        bookingTicket.setPayments(new ArrayList<>());
        return bookingTicketRepository.save(bookingTicket);
    }
}
