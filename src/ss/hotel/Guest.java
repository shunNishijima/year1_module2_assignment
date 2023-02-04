package ss.hotel;
import java.lang.String;
public class Guest {
    /**@
     * private invariant name !=null;
     * private invariant Guestroom !=0;
     */
    String name;
    Room guestroom;
    /**
     * Creates a <code>Guest</code> with the given name.
     * @param name of the new <code>Guest</code>
     */
    //@ requires name!=null;
    //@ ensures this.name == name;
    public Guest(String name){
        this.name = name;
    }
    /**
     * Returns the name of the guest living this room.
     */
    //@ requires name!=null;
    //@ ensures \result == this.name;
    public String getName(){
        return this.name;
    }
    /**
     * Returns the Guestroom which guest living currently.
     * @return the Guestroom rented by this guest, null if not rented
     */
    //@ ensures \result == null || \result == this.guestroom;
    public Room getRoom(){
        if(guestroom !=null){
            return this.guestroom;
        }else {return null;}}
    /**
     * Assigns a room to the Guest
     * @param room the guest renting, if it is not null, return false.
     */
    //@ requires room!=null;
    //@ ensures \result == true || \result==false;
    public boolean checkin(Room room){
        if(this.guestroom ==null && room.getGuest()==null||room.getGuest()==this){
            this.guestroom = room;
            this.guestroom.setGuest(this);
            return true;
        }else{return false;}

    }
    /**
     * Remove assign a guest from room.
     */
    //@ ensures \result==true||\result==false;
    public boolean checkout(){
        if (guestroom !=null){
            this.guestroom.setGuest(null);
            this.guestroom = null;
            return true;}else{return false;}
}
    public String toString(){
        String s = "Guest: "+this.name;
        return s;
    }
}