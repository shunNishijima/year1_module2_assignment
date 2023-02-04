package ss.hotel.password;

public class BasicChecker implements Checker {
    public static final String INITIAL = "password";
    @Override
    public String generatePassword() { return INITIAL; }

    @Override
    public boolean acceptable(String pass) {
        return pass.length() >= 6 && !pass.contains(" ");
    }
}
