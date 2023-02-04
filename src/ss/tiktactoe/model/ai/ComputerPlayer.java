package ss.tiktactoe.model.ai;

import ss.tiktactoe.model.*;

public class ComputerPlayer extends AbstractPlayer {
    private Mark mark;
    private Strategy strategy;


    public ComputerPlayer(Mark mark,Strategy strategy) {
        super("Computer1");
        this.mark = mark;
        this.strategy = strategy;
    }

    @Override
    public Move determineMove(Game game) {
        return this.strategy.determineMove(game);
    }

    public Strategy getStrategy(){return this.strategy;}
    public  void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
}
