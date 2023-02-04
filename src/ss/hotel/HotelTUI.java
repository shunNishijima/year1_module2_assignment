package ss.hotel;

import java.util.Scanner;

public class HotelTUI {
    private Hotel hotel;
    private String gname;

    //make every command
    static final String IN = "in";
    static final String OUT = "out";
    static final String ROOM = "room";
    static final String ACTIVE = "activate";
    static final String HELP = "help";
    static final String PRINT = "print";
    static final String EXIT = "exit";


    public static void main(String[] args) {
        Hotel hotel = new Hotel("hotel Twente");
        HotelTUI hotelTUI = new HotelTUI();
        hotelTUI.hotel = hotel;
        hotelTUI.run(hotelTUI);
    }
    public String parseCommand(String command)
    {
        command = command.toLowerCase();
        String[] split = command.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < split.length; i++)
        {
            sb.append(split[i]+" ");
            //System.out.println(sb);
        }

        gname = sb.toString();
        return split[0];
    }


    public Hotel getHotel()
    {
        return this.hotel;
    }

    public void doIn(){
        Room r =  this.hotel.checkIn(this.gname);

        if (r == null)
        {
            System.out.println("The hotel is full!");
        }
        else
        {
            System.out.println("Guest "+gname+" successfully checked in to"+ " "+this.hotel.getRoom(gname));
        }
    }
    public void doOut(){
        Room g = this.hotel.getRoom(gname);
        if (g == null)

        {
            System.out.println("Guest is not in the system.");
        }
        else
        {
            System.out.println("Guest "+gname+" successfully checked out of room "+g);
            this.hotel.checkOut(gname);
        }
    }
    public void doRoom(){
        if (this.hotel.getRoom(gname) == null)
        {
            System.out.println("Guest "+gname+" does not have a room.");
        }else {
            System.out.println("Guest " + gname + " is in "+this.hotel.getRoom(gname));
        }
    }
    public void doActivate(){
        if (this.hotel.getRoom(gname)!=null)
        {
            this.hotel.getRoom(gname).getSafe().activate();
            System.out.println("Safe activated!");

        }
        else
        {
            System.out.println("Guest "+gname+" does not have a room.");
        }
    }
    public void doHelp(){
        System.out.println("Welcome to the Hotel management system of the \" Hotel Twente \"\n" +
                "Commands :\n" +
                "in [name] ................. check in guest with name\n" +
                "out [name] ................ check out guest with name\n" +
                "room [name] ............... request room of guest with name\n" +
                "activate [name] ........... activate safe of guest with name\n" +
                "help .................... help ( this menu )\n" +
                "print ................... print state\n" +
                "exit .................... exit\n");
    }
    public void doPrint(){
        System.out.println(this.getHotel().toString());
    }
    public void run(HotelTUI hotel) {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the Hotel management system of the \" Hotel Twente \"\n" +
                    "Commands :\n" +
                    "in name ................. check in guest with name\n" +
                    "out name ................ check out guest with name\n" +
                    "room name ............... request room of guest with name\n" +
                    "activate name ........... activate safe of guest with name\n" +
                    "help .................... help ( this menu )\n" +
                    "print ................... print state\n" +
                    "exit .................... exit\n");
            Scanner input = new Scanner(System.in);
            String option = this.parseCommand(input.nextLine());


            switch (option) {
                case IN:
                    doIn();
                    break;

                case OUT:
                   doOut();
                    break;

                case ROOM:
                    doRoom();
                    break;

                case ACTIVE:
                    doActivate();
                    break;

                case HELP:
                    doHelp();
                    break;

                case PRINT:
                    doPrint();
                    break;

                case EXIT:
                    running = false;
                    break;

            }
        }

    }
}
