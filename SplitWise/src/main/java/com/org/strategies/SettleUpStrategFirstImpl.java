package com.org.strategies;

import com.org.dto.Transaction;
import com.org.models.Expense;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SettleUpStrategFirstImpl implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUp(List<Expense> expenseList) {

        /*TODO::  Implement */
        return Collections.emptyList();
    }
}
