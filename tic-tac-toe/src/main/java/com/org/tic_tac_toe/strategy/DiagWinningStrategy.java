package com.org.tic_tac_toe.strategy;

import com.org.tic_tac_toe.models.Board;
import com.org.tic_tac_toe.models.Cell;
import com.org.tic_tac_toe.models.Move;
import com.org.tic_tac_toe.models.Symbol;

public class DiagWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        int x = move.getMovingCell().getX();
        int y = move.getMovingCell().getY();


        Symbol symbol = move.getPlayer().getSymbol();
        int n = board.getSize();
        // 1st Diagonal
        if (x == y) {
            for (int i = 0; i < n; i++) {
                Cell cell = board.getBoard().get(i).get(i);
                if (!symbol.equals(cell.getPlayer().getSymbol())) {
                    return false;
                }
            }
        }

        //2nd Diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == n - 1) {
                    Cell cell = board.getBoard().get(i).get(i);
                    if (!symbol.equals(cell.getPlayer().getSymbol())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}