package com.org.strategies;

import com.org.dto.Transaction;
import com.org.models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SettleUpStrategy {

    public List<Transaction> settleUp(List<Expense> expenseList);
}
