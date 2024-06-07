package com.org.tic_tac_toe.models;

import lombok.Data;

import java.util.Scanner;

@Data
public class Player {
    int id;
    String name;
    Symbol symbol;
    PlayerType playerType;


    /*TODO: Id creation logic */

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        System.out.println("Enter the row and Column");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        return new Move(new Cell(i, j), this);
    }
}
