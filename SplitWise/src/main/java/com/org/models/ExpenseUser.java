package com.org.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ExpenseUser {
    @Id
    private int id;
    @ManyToOne
    private Expense expense;
    @ManyToOne                                                  //??? How
    private User user;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
}
