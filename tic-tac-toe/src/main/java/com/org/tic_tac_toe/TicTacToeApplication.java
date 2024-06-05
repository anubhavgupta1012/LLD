package com.org.tic_tac_toe;


import com.org.tic_tac_toe.controller.GameController;
import com.org.tic_tac_toe.exception.BotGreaterThan1Exception;
import com.org.tic_tac_toe.exception.DuplicatePlayerSymbolException;
import com.org.tic_tac_toe.exception.PlayerCountMismatchException;
import com.org.tic_tac_toe.models.*;
import com.org.tic_tac_toe.strategy.ColWinningStrategy;
import com.org.tic_tac_toe.strategy.DiagWinningStrategy;
import com.org.tic_tac_toe.strategy.RowWinningStrategy;
import com.org.tic_tac_toe.strategy.WinningStrategy;

import java.util.Arrays;
import java.util.List;

public class TicTacToeApplication {

    public static void main(String[] args) throws PlayerCountMismatchException, BotGreaterThan1Exception, DuplicatePlayerSymbolException {

        GameController gameController = new GameController();
        System.out.println("starting game");
        List<Player> players = Arrays.asList(new Player("Anubhav", new Symbol('*'),
                PlayerType.HUMAN), new Player("Dheeraj", new Symbol('*'), PlayerType.HUMAN));
        List<WinningStrategy> winningStrategies = Arrays.asList(new DiagWinningStrategy(), new ColWinningStrategy(), new RowWinningStrategy());
        Game game = gameController.startGame(players, 3, winningStrategies);

        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {
            gameController.makeMove(game);
            gameController.showBoard(game);
        }
    }

}
