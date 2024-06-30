package com.org.book_my_show.service;

import com.org.book_my_show.models.Show;
import com.org.book_my_show.models.ShowSeat;
import com.org.book_my_show.models.ShowSeatType;
import com.org.book_my_show.repository.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {

    @Autowired
    private ShowSeatTypeRepository showSeatTypeRepository;

    public int calculatePriceForShow(Show show, List<ShowSeat> showSeats) {

        List<ShowSeatType> allByShow = showSeatTypeRepository.findAllByShow(show);
        int amount = 0;
        for (ShowSeat seat : showSeats) {
            for (ShowSeatType seatType : allByShow) {
                if (seat.getSeat().getSeatType().equals(seatType.getSeatType())) {
                    amount += seatType.getPrice();
                }
            }
        }
        return amount;
    }
}
