package com.org.commandDP;

import com.org.contoller.ExpenseController;
import com.org.dto.SetleupRequestDto;
import com.org.dto.SettleUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettleUpCommand implements Command {

    @Autowired
    private ExpenseController expenseController;

    @Override
    public void execute(String input) {
        String[] tokens = input.split("");
        int userId = Integer.parseInt(tokens[1]);

        SetleupRequestDto setleupRequestDto = new SetleupRequestDto();
        setleupRequestDto.setUserId(userId);
        SettleUpResponseDto settleUpResponseDto = expenseController.settleUser(setleupRequestDto);

    }

    @Override
    public boolean match(String input) {
        String[] tokens = input.split("");
        return tokens.length == 2 && tokens[1].equalsIgnoreCase("settleUp");
    }
}
