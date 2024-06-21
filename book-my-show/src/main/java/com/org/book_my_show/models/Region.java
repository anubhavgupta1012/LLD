package com.org.book_my_show.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Region {
    @Id
    private int regionId;
    private String name;
    @OneToMany
    private List<Threatre> threatres;
}
