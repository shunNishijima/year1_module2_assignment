package ss.tiktactoe.model.ai;

import ss.tiktactoe.model.*;

import java.util.List;

public class SmartStrategy implements Strategy{
    /**
     * @return "Smart"
     */
    @Override
    public String getName() {
        return "Smart";
    }

    /**
     * @param game
     * @return
     */
    @Override
    public Move determineMove(Game game) {
        TictacToeGame tictacToeGame = (TictacToeGame) game;
        if(findWinningMove(game)!=null){
            return findWinningMove(game);
        }
        tictacToeGame.switchTurn();
        if(findWinningMove(tictacToeGame)!=null){
            Move move = findWinningMove(tictacToeGame);
            tictacToeGame.switchTurn();

            move.setMark(tictacToeGame.getMark());
            return move;
        }else{
            tictacToeGame.switchTurn();
            return tictacToeGame.getValidMoves().get(Random(tictacToeGame.getValidMoves().size(),0));
        }
    }
    public  int Random(int max,int min){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Move findWinningMove(Game game){
        List<TicTacToeMove> validMoves = game.getValidMoves();
        TictacToeGame deepcopy = ((TictacToeGame) game).deepcopy(game);
        for(int i=0;i<validMoves.size();i++){
            deepcopy.doMove(validMoves.get(i));
            if(deepcopy.board.hasWinner()){
                deepcopy.board.setField(validMoves.get(i).getLocation(),Mark.EMPTY);
                return validMoves.get(i);
            }
            deepcopy.board.setField(validMoves.get(i).getLocation(),Mark.EMPTY);
        }
        return null;
    }
}
