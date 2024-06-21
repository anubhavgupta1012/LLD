package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity(name = "Shows")
@Data
public class Show {
    @Id
    private int showId;
    @ManyToOne
    private Movie movie;    /*Its show not screen, hence ManyToOne */
    private Timestamp startTime;
    private Timestamp endTime;
    @ManyToOne
    private Screen screen;
}