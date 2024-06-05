package com.org.tic_tac_toe.models;

import com.org.tic_tac_toe.exception.BotGreaterThan1Exception;
import com.org.tic_tac_toe.exception.DuplicatePlayerSymbolException;
import com.org.tic_tac_toe.exception.PlayerCountMismatchException;
import com.org.tic_tac_toe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    Player winner;
    List<WinningStrategy> strategies;
    int nextPlayerTurnIndex;
    GameState gameState;
    List<Move> moves;

    private Game(GameBuilder gameBuilder) {
        board = new Board(gameBuilder.dimention);
        players = gameBuilder.players;
        strategies = gameBuilder.winningStrategies;
        nextPlayerTurnIndex = 0;
        gameState = GameState.IN_PROGRESS;
        moves = new ArrayList<>();
    }

    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }

    public void makeMove() {
        Player player = players.get(nextPlayerTurnIndex);
        System.out.println("Its " + player.name + "'s turn, Make your move.");
        Move move = player.makeMove(board);

        //Validate the move
    }

    public static class GameBuilder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimention;


        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public GameBuilder setDimention(int dimention) {
            this.dimention = dimention;
            return this;
        }

        /*      some Extra methods just for code ease     */

        public GameBuilder addPlayer(Player player) {
            if (players == null) players = new ArrayList<>();

            players.add(player);
            return this;
        }

        public GameBuilder addWinningStrategy(WinningStrategy winningStrategy) {
            if (winningStrategies == null) winningStrategies = new ArrayList<>();

            winningStrategies.add(winningStrategy);
            return this;
        }

        /*  till above, some Extra methods just for code ease   */

        public Game build() throws PlayerCountMismatchException, BotGreaterThan1Exception, DuplicatePlayerSymbolException {
            validate();
            return new Game(this);
        }


        /*  code for validations  */
        // TODO:  All Validation Should be done in a Separate GameValidator Class, and all Validation Code should be moved inside that class.
        // In Actual Interview , I will let it be here to save some time and let interviewer also know that I am thinking about validation.
        private void validate() throws BotGreaterThan1Exception, PlayerCountMismatchException, DuplicatePlayerSymbolException {
            validateBotCount();
            validatePlayerCount();
            validateUniqueSymbolsForPlayers();
        }

        private void validateBotCount() throws BotGreaterThan1Exception {
            int botCount = 0;
            for (Player player : players)
                if (player.playerType.equals(PlayerType.BOT)) botCount++;
            if (botCount > 1) throw new BotGreaterThan1Exception();
        }


        private void validatePlayerCount() throws PlayerCountMismatchException {
            if (players.size() != dimention - 1) throw new PlayerCountMismatchException();
        }

        private void validateUniqueSymbolsForPlayers() throws DuplicatePlayerSymbolException {
            HashSet<Character> set = new HashSet();
            for (Player player : players) {
                if (!set.add(player.symbol.symbol)) throw new DuplicatePlayerSymbolException();
            }
        }
    }
}
