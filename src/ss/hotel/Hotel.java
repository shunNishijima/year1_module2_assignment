package ss.hotel;

import java.util.ServiceConfigurationError;

public class Hotel {
    private String name;
    protected Room room1;
    protected Room room2;

    //@requires name!=null;
    //@ensures this.name==name;
    public Hotel(String name){
        this.name = name;
        room1 = new Room(101,new Safe());
        room2 = new Room(102,new Safe());
    }

    //@requires name!=null;
    //@ensures \result==null||\result==room1||\result==room2;
    public Room checkIn(String name){
        Room room = this.getFreeRoom();
        if(room==null){
            return null;
        }else{
            room.setGuest(new Guest(name));
            room.getGuest().checkin(room);
            return room;}}

    //@requires name!=null;
    public void checkOut(String name){
        Room room = this.getRoom(name);
        if(room!=null){
            room.getSafe().deactivate();
            room.getGuest().checkout();
            room = null;
    }}

    //@ensures \result==null||\result==room1||\result==room2;
    public Room getFreeRoom(){
        if(room1.getGuest()!=null&&room2.getGuest()!=null){
            return null;
        } else if (room1.getGuest()==null) {
            return room1;
        }else {
        return room2;
    }}

    //@requires name!=null;
    //@ensures \result==null||\result==room1||\result==room2;
    public Room getRoom(String name){
        if(room1.getGuest()!=null && room1.getGuest().name.equals(name)){
            return room1;
        } else if (room2.getGuest()!=null && room2.getGuest().name.equals(name)) {
            return room2;
        }else {
        return null;
    }}


    public String toString(){
        if(room1.getGuest()!=null&&room2.getGuest()!=null){
            return "Room1: " +room1.toString()+" "+room1.getGuest().toString()+"\n"+"Room2: " +room2.toString()+" "+room2.getGuest().toString();
        }else if(room1.getGuest()!=null&&room2.getGuest()==null){
            return "Room1: " +room1.toString()+" "+room1.getGuest().toString()+"\n"+"Room2: " +room2.toString()+" "+null;
        }else if(room1.getGuest()==null&&room2.getGuest()!=null) {
            return "Room1: " + room1.toString() + " " + null + "\n" + "Room2: " + room2.toString() + " " + room2.getGuest().toString();
        }else{
            return "Room1: " + room1.toString() + " " + null + "\n" + "Room2: " + room2.toString() + " " + null;
        }

    }
}
