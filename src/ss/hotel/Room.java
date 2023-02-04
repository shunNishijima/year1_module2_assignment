package ss.hotel;

public class Room {
    private Integer roomnumber;
    private Guest guest;
    private  Safe safe;
    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param  number of the new <code>Room</code>
     */
    //@requires number!=0;
    public Room(int number) {
    	this.roomnumber = number;
        this.safe = new Safe();
    }
    /**
     * Returns the safe in the current room.
     * @return the safe status of this Room.
     */
    public Safe getSafe(){
        return this.safe;
    }
    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param  number of the new <code>Room</code>
     * @param  safe of the new <code>Room</code>
     */
    public Room(int number,Safe safe){
        this.roomnumber = number;
        this.safe = safe;
    }


    /**
     * Returns the number of this Room
     */
    public int getNumber() {
    	if(roomnumber ==0){
            return 0;
        }
        return roomnumber;
    }

    /**
     * Returns the current guest living in this Room
     * @return the guest of this Room, null if not rented
     */
    public Guest getGuest() {
    	return guest;
    }
    
    
    /**
     * Assigns a Guest to this Room.
     * @param guest the new guest renting this Room, if null is given, Room is empty afterwards
     */
    public void setGuest(Guest guest) {
    	this.guest = guest;
    }
    public String toString(){
        return "Room: " + this.roomnumber;
    }
}
