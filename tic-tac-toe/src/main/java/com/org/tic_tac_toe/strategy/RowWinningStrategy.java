package com.org.tic_tac_toe.strategy;

import com.org.tic_tac_toe.models.Board;
import com.org.tic_tac_toe.models.Cell;
import com.org.tic_tac_toe.models.Move;
import com.org.tic_tac_toe.models.Symbol;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        int x = move.getMovingCell().getX();
        Symbol symbol = move.getPlayer().getSymbol();
        int n = board.getSize();

        for (int i = 0; i < n; i++) {
            Cell cell = board.getBoard().get(x).get(i);
            if (!symbol.equals(cell.getPlayer().getSymbol())) {
                return false;
            }
        }
        return true;
    }
}
