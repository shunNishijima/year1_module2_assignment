package ss.tiktactoe.model.ui;

import ss.tiktactoe.model.Mark;
import ss.tiktactoe.model.Player;
import ss.tiktactoe.model.TicTacToeMove;
import ss.tiktactoe.model.TictacToeGame;
import ss.tiktactoe.model.ai.ComputerPlayer;
import ss.tiktactoe.model.ai.NaiveStrategy;
import ss.tiktactoe.model.ai.SmartStrategy;

import java.util.Scanner;

public class TicTacToeTUI {
    private TictacToeGame tictacToeGame;
    public static void main(String[] args) {
        TicTacToeTUI ticTacToeTUI = new TicTacToeTUI();
        ticTacToeTUI.run();
    }
    public void run(){
        Player player1;
        Player player2;
        boolean playing = true;
        while(playing){
            Scanner input = new Scanner(System.in);
            System.out.println("What is your name? for player1");
            String name = input.nextLine();
            if(name.equals("-S")){
                player1 = new ComputerPlayer(Mark.BLACK,new SmartStrategy());
            } else if (name.equals("-N")) {
                player1 = new ComputerPlayer(Mark.BLACK,new NaiveStrategy());
            }else {
            player1 = new HumanPlayer(name);}

            System.out.println("What is your name? for player2");
            name = input.nextLine();
            if (name.equals("-S")){
                player2 = new ComputerPlayer(Mark.OO,new SmartStrategy());
            } else if (name.equals("-N")) {
                player2 = new ComputerPlayer(Mark.OO,new NaiveStrategy());
            }else {
            player2 = new HumanPlayer(name);}

            this.tictacToeGame = new TictacToeGame(player1,player2);
            while (!tictacToeGame.isGameover()){
                System.out.println(tictacToeGame.board.toString());
                tictacToeGame.doMove((TicTacToeMove) tictacToeGame.getTurn().determineMove(tictacToeGame));
                if(tictacToeGame.board.hasWinner()){
                    System.out.println(tictacToeGame.board.toString());
                    System.out.println(tictacToeGame.getWinner()+" is the winner!");
                } else  {
                    tictacToeGame.switchTurn();
                }
                }
            System.out.println("Game is Over");
            System.out.println("Do you want to play again? y or n");
            String again = input.nextLine();
            switch (again){
                case "y":
                    playing = true;
                    break;
                case "n":
                    playing = false;
                    break;
                default:
                    break;
            }
            }

        }
    }
