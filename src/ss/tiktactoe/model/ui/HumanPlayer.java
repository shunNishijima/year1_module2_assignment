package ss.tiktactoe.model.ui;

import ss.tiktactoe.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
    /**
     * Creates a new Player object.
     *
     * @param name
     */
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public TicTacToeMove determineMove(Game game) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please put your move: \n");
        TicTacToeMove ticTacToeMove = makeMove(input);
        while(ticTacToeMove==null||!game.isValidMove(ticTacToeMove)){
            System.out.println("Invalid. Put it again: \n");
            ticTacToeMove = makeMove(input);
        }
        return ticTacToeMove;
    }
    public TicTacToeMove makeMove(Scanner input) {
        String command = input.nextLine();
        String[] split = command.split("\\s+");

        switch (split[0]) {
            case "BLACK":
                return new TicTacToeMove(Mark.BLACK, Integer.parseInt(split[1]));
            case "OO":
                return new TicTacToeMove(Mark.OO, Integer.parseInt(split[1]));
            default:
                return null;
        }
    }
}
