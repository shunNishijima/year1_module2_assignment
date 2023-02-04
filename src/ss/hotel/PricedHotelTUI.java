package ss.hotel;

import ss.hotel.bill.Bill;
import ss.hotel.bill.BillPrinter;
import ss.hotel.bill.StringBillPrinter;
import ss.hotel.bill.SysoutBillPrinter;
import ss.hotel.password.Password;

import java.util.Scanner;

public class PricedHotelTUI {
        private PricedHotel pricedHotel;
        private String gname;
        private String[] input;
        private BillPrinter billPrinter;

        //make every command
        static final String IN = "in";
        static final String OUT = "out";
        static final String ROOM = "room";
        static final String ACTIVE = "activate";
        static final String BILL = "bill";
        static final String HELP = "help";
        static final String PRINT = "print";
        static final String EXIT = "exit";


        public static void main(String[] args) {
            ss.hotel.PricedHotelTUI pricedHotelTUI = new ss.hotel.PricedHotelTUI();
            pricedHotelTUI.pricedHotel = new PricedHotel("hotel Twente");
            pricedHotelTUI.billPrinter = new SysoutBillPrinter();
            pricedHotelTUI.run(pricedHotelTUI);
        }
        public String parseCommand(String command)
        {
            command = command.toLowerCase();
            this.input = command.split("\\s+");
            if(input.length>=2){
                this.gname = input[1];
            }
            return input[0];
        }

        public Hotel getHotel()
        {
            return this.pricedHotel;
        }
        public void doIn(){
            Room r =  this.pricedHotel.checkIn(this.gname);

            if (r == null)
            {
                System.out.println("The hotel is full!");
            }
            else
            {
                System.out.println("Guest "+gname+" successfully checked in to"+ " "+this.pricedHotel.getRoom(gname));
            }
        }
        public void doOut(){
            Room g = this.pricedHotel.getRoom(gname);
            if (g == null)

            {
                System.out.println("Guest is not in the system.");
            }
            else
            {
                System.out.println("Guest "+gname+" successfully checked out of room "+g);
                this.pricedHotel.checkOut(gname);
            }
        }
        public void doRoom(){
            if (this.pricedHotel.getRoom(gname) == null)
            {
                System.out.println("Guest "+gname+" does not have a room.");
            }else {
                System.out.println("Guest " + gname + " is in "+this.pricedHotel.getRoom(gname));
            }
        }
        public void doActivate(){
            if(input.length<3&&this.pricedHotel.getRoom(gname) instanceof  PricedRoom){
                System.out.println("Wrong params at activation (password required)\n");
            } else if (this.pricedHotel.getRoom(gname)!=null&&this.pricedHotel.getRoom(gname) instanceof  PricedRoom) {
                ((PricedSafe) this.pricedHotel.getRoom(gname).getSafe()).activate(this.input[2]);
                if (this.pricedHotel.getRoom(gname).getSafe().isActive()) {
                    System.out.println("Safe in room " + this.pricedHotel.getRoom(gname).getNumber() + " of guest " + gname + " has been activated.");
                }
            } else if (this.pricedHotel.getRoom(gname)!=null && !(this.pricedHotel.getRoom(gname) instanceof  PricedRoom)) {
                    this.pricedHotel.getRoom(gname).getSafe().activate();
                    System.out.println("Safe in room "+this.pricedHotel.getRoom(gname).getNumber()+" of guest "+gname+" has been activated.");
            } else {
                System.out.println("Guest "+gname+" does not have a room.");
            }
        }
        public void doHelp(){
            System.out.println("Welcome to the Hotel management system of the \" Hotel Twente \"\n" +
                    "Commands :\n" +
                    "in [name] ................. check in guest with name\n" +
                    "out [name] ................ check out guest with name\n" +
                    "room [name] ............... request room of guest with name\n" +
                    "activate name password .. activate safe, password required for PricedSafe\n" +
                    "bill name nights......... print bill for guest (name) and number of nights\n" +
                    "help .................... help ( this menu )\n" +
                    "print ................... print state\n" +
                    "exit .................... exit\n");
        }
        public void doPrint(){
            System.out.println(this.pricedHotel.toString());
        }
        public void doBill(){
            if(input.length<3){
                System.out.println("night required");
            } else if (this.pricedHotel.getRoom(gname)!=null&&this.pricedHotel.getRoom(gname) instanceof  PricedRoom) {
                System.out.println("bill "+gname+" "+input[2]);
                this.pricedHotel.getBill(gname,Integer.parseInt(input[2]),billPrinter);
            }else{
                System.out.println("room is not priced");
            }
        };

        public void run(PricedHotelTUI pricedHotelTUI) {
            boolean running = true;
            while (running) {
                System.out.println("Welcome to the Hotel management system of the \" Hotel Twente \"\n" +
                        "Commands :\n" +
                        "in name ................. check in guest with name\n" +
                        "out name ................ check out guest with name\n" +
                        "room name ............... request room of guest with name\n" +
                        "activate name password .. activate safe, password required for PricedSafe\n" +
                        "bill name nights......... print bill for guest (name) and number of nights\n" +
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

                    case BILL:
                        doBill();
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

