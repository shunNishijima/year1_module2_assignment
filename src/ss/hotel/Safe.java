package ss.hotel;

public class Safe {
    //@ public invariant isOpen()==>isActive();

    private Boolean open;
    private Boolean activated;

    //@ ensures this.open == false && this.activated==false;
    public Safe(){
        this.open = false;
        this.activated = false;
    }
    //@ ensures this.activated == true;
    public void activate(){
        this.activated = true;
    }
    //@ ensures this.open==false&&this.activated==false;
    public void deactivate(){
        this.open = false;
        this.activated = false;
    }
    //@ensures this.open==true||this.open==false;
    public void open(){
        if(this.activated){
            this.open=true;
        }
    }
    //@ensures this.open==false;
    public void close(){
        this.open = false;
    }

    //@ensures \result==true||\result==false;
    public Boolean isActive(){
        if(this.activated){
          return true;
        }else {
            return false;
        }
    }
    //@ensures \result==true||\result==false;
    public Boolean isOpen(){
        if(this.open){
            return true;
        }else{return false;}
    }
}
