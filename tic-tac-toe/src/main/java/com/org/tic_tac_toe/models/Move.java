package com.org.tic_tac_toe.models;

public class Move {
    Cell movingCell;
    Player player;

    public Move(Cell movingCell, Player player) {
        this.movingCell = movingCell;
        this.player = player;
    }
}
