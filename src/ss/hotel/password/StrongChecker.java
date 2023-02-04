package ss.hotel.password;

public class StrongChecker extends BasicChecker {
    public static final String INITIAL = "pass1234";
    @Override
    public String generatePassword() { return INITIAL; }

    @Override
    public boolean acceptable(String pass) {
        return  super.acceptable(pass) && Character.isLetter(pass.charAt(0)) && Character.isDigit(pass.charAt(pass.length()-1));
    }}
