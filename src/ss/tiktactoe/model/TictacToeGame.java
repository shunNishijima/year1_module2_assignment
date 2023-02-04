package ss.tiktactoe.model;

import java.util.ArrayList;
import java.util.List;

public class TictacToeGame implements Game{

    public Board board;
    private Player player1;
    private Player player2;
    private int turn = 0;

    public TictacToeGame(Player player1,Player player2){
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean isGameover() {
        return board.hasWinner()||board.isFull();
    }

    @Override
    public Player getTurn() {
        if (turn == 0) {
            return player1;
        } else {
            return player2;
        }
    }

    public void switchTurn(){//turn ++ % 2
        if(turn==0){
            turn=1;
        }else {
            turn=0;
        }
    }

    @Override
    public Player getWinner() {
        if(board.hasWinner()){
            return getTurn();
        }
        return null;
    }

    @Override
    public List<TicTacToeMove> getValidMoves() {
        List<TicTacToeMove> validmoves = new ArrayList<>();
        if (getTurn() == player1) {
            for (int i = 0; i < board.DIM * board.DIM; i++) {
                TicTacToeMove ticTacToeMove = new TicTacToeMove(Mark.BLACK, i);
                if (isValidMove(ticTacToeMove)) {
                    validmoves.add(ticTacToeMove);
                }
            }
        }
        if (getTurn() == player2) {

            for (int i = 0; i < board.DIM * board.DIM; i++) {
                TicTacToeMove ticTacToeMove = new TicTacToeMove(Mark.OO, i);
                if (isValidMove(ticTacToeMove)) {
                    validmoves.add(ticTacToeMove);
                }
            }
        }
        return validmoves;
    }

    @Override
    public boolean isValidMove(TicTacToeMove tictactoemove) {
        if(getTurn()==player1&&tictactoemove.getMark()==Mark.BLACK || getTurn()==player2&&tictactoemove.getMark()==Mark.OO){
            return !isGameover()&&board.isEmptyField(tictactoemove.getLocation());
        }else{
            return false;
        }
    }
    @Override
    public void doMove(TicTacToeMove move) {
        if(isValidMove(move)){
            board.setField(move.getLocation(),move.getMark());
        }
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public TictacToeGame deepcopy(Game game){
        TictacToeGame deepcopy = new TictacToeGame(this.player1, this.player2);
        deepcopy.setBoard(((TictacToeGame)game).board);
        deepcopy.turn = ((TictacToeGame) game).turn;
        return  deepcopy;
    }

    public Mark getMark(){
        if(this.turn==0){
            return Mark.BLACK;
        }else {
            return Mark.OO;
        }
    }
}
