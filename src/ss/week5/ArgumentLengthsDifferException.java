package ss.week5;

public class ArgumentLengthsDifferException extends WrongArgumentException{
    int i1;
    int i2;

    public ArgumentLengthsDifferException(int i1,int i2){
        super();
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public String getMessage() {
        return "error: length of command line arguments "
                + "differ (" + this.i1 + ", " + this.i2 + ")";
    }
}
