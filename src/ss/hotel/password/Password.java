package ss.hotel.password;

public class Password {
        private String storepass;
        private Checker checker;
        public String initPass;

    /**
     *
     * @return getter for initPass
     */
    //@ensures \result==initPass;
    public String getInitPass() {return this.initPass;}

    /**
     *
     * @return getter for checker
     */
    //@ensures \result==checker;
    public Checker getChecker() {return this.checker;}


    /**
     *
     * @param checker make sure if password is acceptable
     */
    //@requires checker!=null;
    public Password(Checker checker){
        this.checker = checker;
        initPass = checker.generatePassword();
        this.storepass = initPass;
        }

    /**
     * default constructor
     */
    public Password(){
        this(new BasicChecker());
    }

    /**
     *
     * @param suggestion is suggested password
     * @return if it's acceptable or not
     */
    //@requires suggestion!=null;
    //@ensures \result==true||\result==false;
        public boolean acceptable(String suggestion){
            return checker.acceptable(suggestion);
        }

    /**
     *
     * @param test is password which is tested if equal to correct password is stored
     * @return if it's correct password or not.
     */
    //@requires test!=null;
    //@ensures \result==true||\result==false;
    public boolean testWord(String test){
            return  test.equals(this.storepass);
        }

    /**
     *
     * @param oldpass as former correct password
     * @param newpass as new password will be set as correct password and go to storepass
     * @return if it's false any happen and return false. if it's true newpass store to storepass and return true.
     */
    //@requires oldpass!=null&&newpass!=null;
    //@ensures \result==true||\result==false;
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
