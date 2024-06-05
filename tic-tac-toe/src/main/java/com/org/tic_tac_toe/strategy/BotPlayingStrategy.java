package com.org.tic_tac_toe.strategy;

import com.org.tic_tac_toe.models.Board;
import com.org.tic_tac_toe.models.Bot;
import com.org.tic_tac_toe.models.Move;
import com.org.tic_tac_toe.models.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player bot);
}
