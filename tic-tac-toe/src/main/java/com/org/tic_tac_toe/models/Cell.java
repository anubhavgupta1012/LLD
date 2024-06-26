package com.org.tic_tac_toe.models;

public class Cell {
    private int x;
    private int y;
    private Player player;
    private CellState cellState;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.cellState = CellState.EMPTY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player getPlayer() {
        return player;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void printCell() {
        if (this.getPlayer() == null) {
            System.out.print("\t_\t");
        } else
            System.out.print("\t" + this.getPlayer().symbol.symbol + "\t");
    }
}
