package com.org.tic_tac_toe.strategy;

import com.org.tic_tac_toe.models.Board;
import com.org.tic_tac_toe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
