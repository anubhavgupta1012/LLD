package com.org.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "userGroup")
@Data
public class Group {

    @Id
    private int id;
    private String name;
    @ManyToOne
    private User admin;
    @ManyToMany
    private List<User> members;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;     // Already present in Expense Class, Using Group Variable, Java Will consider it
    // two different mapping , hence to make it only one relation, use mapped by or remove expenses.
}
