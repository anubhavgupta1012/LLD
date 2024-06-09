package com.org.tic_tac_toe;


import com.org.tic_tac_toe.controller.GameController;
import com.org.tic_tac_toe.exception.BotGreaterThan1Exception;
import com.org.tic_tac_toe.exception.DuplicatePlayerSymbolException;
import com.org.tic_tac_toe.exception.PlayerCountMismatchException;
import com.org.tic_tac_toe.models.*;
import com.org.tic_tac_toe.strategy.*;

import java.util.Arrays;
import java.util.List;

public class TicTacToeApplication {

    public static void main(String[] args) throws PlayerCountMismatchException, BotGreaterThan1Exception, DuplicatePlayerSymbolException {

        GameController gameController = new GameController();
        System.out.println("starting game");

        // TODO: Command line Design Pattern for main class
        List<Player> players = Arrays.asList(new Player("Anubhav", new Symbol('*'), PlayerType.HUMAN),
                new Bot("BOT 1", new Symbol('O'), new Easy()));
        List<WinningStrategy> winningStrategies = Arrays.asList(new DiagWinningStrategy(), new ColWinningStrategy(), new RowWinningStrategy());
        Game game = gameController.startGame(players, 3, winningStrategies);

        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {
            gameController.makeMove(game);
            gameController.showBoard(game);
        }

        System.out.println("Game Ended");
        GameState gameState = game.getGameState();
        System.out.println(gameState == GameState.DRAW ? "Game draw" : game.getWinner().getName() + " is THE WINNER");
    }

}
