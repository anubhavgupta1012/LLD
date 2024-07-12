package com.org.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Expense {
    @Id
    private int id;
    private String description;
    private int amount;
    private Timestamp createdAt;
    @ManyToOne
    private User createdBy;
    @ManyToOne
    private Group group;
    @Enumerated
    private ExpenseType expenseType;
    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUserList;
}
