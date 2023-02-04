package ss.week5;

public class TooFewArgumentsException extends WrongArgumentException{
    @Override
    public String getMessage() {
        return "error: too few command line arguments";
    }
}
