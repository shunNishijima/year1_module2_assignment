package ss.tiktactoe.model.ai;

import ss.tiktactoe.model.Game;
import ss.tiktactoe.model.Move;

public interface Strategy {
    String getName();
    Move determineMove(Game game);
}
