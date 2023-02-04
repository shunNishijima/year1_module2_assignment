package ss.tiktactoe.model;

/**
 * Exam2.A player of a turn-based game.
 */
public interface Player {

    Move determineMove(Game game);
}
