package ss.hotel.password;

public interface Checker {
    //@requires pass!=null;
    //@ensures \result==true||\result==false;
    public boolean acceptable(String pass);

    //@ensures \result!=null;
    public String generatePassword();
}
