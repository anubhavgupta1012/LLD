package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Screen {
    @Id
    private String id;
    private String name;
    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
