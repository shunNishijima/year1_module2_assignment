package ss.hotel.password;

public class BasicPassword {
    public static final String INITIAL = "password";
    private String storepass;

    public BasicPassword(){
        this.storepass = INITIAL;
    }

    public boolean acceptable(String suggestion){
        return suggestion.length() >= 6 && !suggestion.contains(" ");
    }
    public boolean testWord(String test){
        return  test.equals(this.storepass);
    }

    public boolean setWord(String oldpass,String newpass){
        if(testWord(oldpass)){
            if(acceptable(newpass)){
                this.storepass = newpass;
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

}
