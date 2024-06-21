package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Threatre {
    @Id
    private String id;
    private String name;
    @ManyToOne
    private Region region;
    @ManyToMany
    private List<Show> shows;
    @OneToMany
    private List<Screen> screens;
}
