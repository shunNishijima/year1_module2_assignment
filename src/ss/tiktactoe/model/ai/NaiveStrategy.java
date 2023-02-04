package ss.tiktactoe.model.ai;

import ss.tiktactoe.model.Game;
import ss.tiktactoe.model.Move;
import ss.tiktactoe.model.Player;
import ss.tiktactoe.model.TictacToeGame;
import ss.tiktactoe.model.ui.HumanPlayer;

public class NaiveStrategy implements Strategy{

    @Override
    public String getName() {
        return "Naive";
    }

    @Override
    public Move determineMove(Game game) {
        TictacToeGame tictacToeGame = ((TictacToeGame) game) ;
        return tictacToeGame.getValidMoves().get(Random(tictacToeGame.getValidMoves().size(),0));
    }

    public  int Random(int max,int min){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {
        NaiveStrategy n = new NaiveStrategy();
        HumanPlayer p1 = new HumanPlayer("x");
        HumanPlayer p2 = new HumanPlayer("d");
        TictacToeGame g = new TictacToeGame(p1,p2);
       System.out.println(n.determineMove(g).toString());
    }
}
