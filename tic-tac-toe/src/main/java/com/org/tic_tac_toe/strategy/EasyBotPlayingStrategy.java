package com.org.tic_tac_toe.strategy;

import com.org.tic_tac_toe.models.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> board1 = board.getBoard();
        for (List<Cell> list : board1) {
            for (Cell cell : list) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, player);
                }
            }
        }
        return null;
    }
}




