package com.org.tic_tac_toe.strategy;

import com.org.tic_tac_toe.models.Player;

public interface WinningStrategy {
    Player checkWinner();
}
