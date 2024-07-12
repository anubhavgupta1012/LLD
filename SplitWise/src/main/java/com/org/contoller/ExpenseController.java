package com.org.contoller;

import com.org.dto.SetleupRequestDto;
import com.org.dto.SettleUpResponseDto;
import com.org.dto.Transaction;
import com.org.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    public SettleUpResponseDto settleUser(SetleupRequestDto requestDto) {
        List<Transaction> transactions = expenseService.settleUpUser(requestDto.getUserId());
        return null;
    }


    public SettleUpResponseDto settleGroup(SetleupRequestDto requestDto) {
        List<Transaction> transactions = expenseService.settleUpGroup(requestDto.getUserId());
        return null;
    }
}
