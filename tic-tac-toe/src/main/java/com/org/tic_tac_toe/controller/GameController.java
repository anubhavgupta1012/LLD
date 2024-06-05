package com.org.tic_tac_toe.controller;

import com.org.tic_tac_toe.exception.BotGreaterThan1Exception;
import com.org.tic_tac_toe.exception.DuplicatePlayerSymbolException;
import com.org.tic_tac_toe.exception.PlayerCountMismatchException;
import com.org.tic_tac_toe.models.Game;
import com.org.tic_tac_toe.models.GameState;
import com.org.tic_tac_toe.models.Player;
import com.org.tic_tac_toe.strategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(List<Player> playerList, int size, List<WinningStrategy> winningStrategies)
            throws PlayerCountMismatchException, BotGreaterThan1Exception, DuplicatePlayerSymbolException {

        Game game = Game.getBuilder().setPlayers(playerList)
                .setWinningStrategies(winningStrategies)
                .setDimention(size).build();
        return game;
    }

    public GameState getGameState(Game game) {
        return null;
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void showBoard(Game game) {

    }

    public Player getWinner(Game game) {
        return null;
    }

    public void undo(Game game) {

    }
}
