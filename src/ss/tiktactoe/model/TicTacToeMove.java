package ss.tiktactoe.model;

public class TicTacToeMove implements Move{
    private Mark mark;
    private int location;

    public TicTacToeMove(Mark mark,int location){
        this.mark =mark;
        this.location = location;
    }

    public Mark getMark(){
        return this.mark;
    }
    public int getLocation(){
        return this.location;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
