package com.org.tic_tac_toe.models;

import com.org.tic_tac_toe.strategy.BotDifficultyLevel;
import com.org.tic_tac_toe.strategy.BotPlayingStrategy;
import com.org.tic_tac_toe.strategy.BotPlayingStrategyFactory;

public class Bot extends Player {

    int botId;
    BotDifficultyLevel botDifficultyLevel;

    BotPlayingStrategy botPlayingStrategy;


    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getStrategy(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        /*  Don't use if else to decide which type of Bot will make move instead use polymorphism  */
        Move move = botPlayingStrategy.makeMove(board, this);
        return move;
    }
}
