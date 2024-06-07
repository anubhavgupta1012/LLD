package com.org.tic_tac_toe.strategy;

import com.org.tic_tac_toe.models.Board;
import com.org.tic_tac_toe.models.Cell;
import com.org.tic_tac_toe.models.Move;
import com.org.tic_tac_toe.models.Symbol;

public class ColWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        int y = move.getMovingCell().getY();
        Symbol symbol = move.getPlayer().getSymbol();
        int n = board.getSize();

        for (int i = 0; i < n; i++) {
            Cell cell = board.getBoard().get(i).get(y);
            if (!symbol.equals(cell.getPlayer().getSymbol())) {
                return false;
            }
        }
        return true;
    }
}