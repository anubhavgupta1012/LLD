package com.org.tic_tac_toe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        board = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            ArrayList<Cell> list = new ArrayList<>();
            board.add(list);
            for (int j = 0; j < size; j++)
                list.add(new Cell(i, j));

        }
    }

    public int getSize() {
        return size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void printBoard() {
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                cell.printCell();
            }
            System.out.println();
        }
    }
}
