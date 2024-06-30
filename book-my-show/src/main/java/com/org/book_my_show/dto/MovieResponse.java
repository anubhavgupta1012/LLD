package com.org.book_my_show.dto;

import com.org.book_my_show.models.ResponseStatus;
import com.org.book_my_show.models.ShowSeat;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieResponse {
    private List<ShowSeat> showSeatIds;
    private int userId;
    private int showId;
    private ResponseStatus responseStatus;
    private int amount;
    private int bookingId;
}
