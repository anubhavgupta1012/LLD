package com.org.tic_tac_toe.strategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getStrategy(BotDifficultyLevel botDifficultyLevel) {
        /*TODO : Handle Strategy*/
        if (botDifficultyLevel instanceof Easy) return new EasyBotPlayingStrategy();
        else if (botDifficultyLevel instanceof Medium) return new MideumBotPlayingStrategy();
        return new HardBotPlayingStrategy();
    }
}
