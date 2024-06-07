package com.org.tic_tac_toe.models;

public class Move {
    Cell movingCell;
    Player player;

    public Move(Cell movingCell, Player player) {
        this.movingCell = movingCell;
        this.player = player;
    }

    public Cell getMovingCell() {
        return movingCell;
    }

    public void setMovingCell(Cell movingCell) {
        this.movingCell = movingCell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
