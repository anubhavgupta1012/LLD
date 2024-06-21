package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Movie {

    @Id
    private int movieId;
    private String name;
    /*private List<String> actors;*/
}
