package com.org.book_my_show.dto;

import lombok.Data;

import java.util.List;

@Data
public class MovieRequest {
    private List<Integer> showSeatIds;
    private int userId;
    private int showId;

}
