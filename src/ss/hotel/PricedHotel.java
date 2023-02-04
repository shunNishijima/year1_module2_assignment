package ss.hotel;

import ss.hotel.bill.Bill;
import ss.hotel.bill.BillPrinter;

public class PricedHotel extends Hotel {

    public static final double ROOM_PRICE = 6.98;
    public static final double SAFE_PRICE = 8.76;

    public PricedHotel(String name) {
        super(name);
        this.room1 = new PricedRoom(0, ROOM_PRICE, SAFE_PRICE);
    }

    public Bill getBill(String name, int night, BillPrinter billPrinter) {
        if (this.getRoom(name) == null || !(this.getRoom(name) instanceof PricedRoom)) {
            return null;
        } else {
            Bill bill = new Bill(billPrinter);
            for (int i = 0; i < night; i++) {
                bill.addItem((Bill.Item) this.room1);
            }
            if (this.room1.getSafe().isActive()) {
                bill.addItem((Bill.Item) this.room1.getSafe());
            }
            bill.close();
            return bill;
        }
    }

    public String toString() {
        if (room1.getGuest() != null && room2.getGuest() != null) {
            return "Hotel Twente\n Room 101 "+"("+ROOM_PRICE+ "/night) :\n"
                    + "   rented by" + room1.getGuest().toString() + "\n"
                    +"   safe active:"+room1.getSafe().isActive()+ "\n"
                    + "Room 102:\n" + "    rented by: " + room2.getGuest().toString()+"\n"
                    +"    safe active:  "+room2.getSafe().isActive();
        } else if (room1.getGuest() != null && room2.getGuest() == null) {
            return "Hotel Twente\n Room 101 "+"("+ROOM_PRICE+ "/night) :\n"
                    + "   rented by" + room1.getGuest().toString() + "\n"
                    +"   safe active:"+room1.getSafe().isActive()+ "\n"
                    + "Room 102:\n" + "    rented by: " + null+"\n"
                    +"    safe active:  "+false;
        } else if (room1.getGuest() == null && room2.getGuest() != null) {
            return "Hotel Twente\n Room 101 "+"("+ROOM_PRICE+ "/night) :\n"
                    + "   rented by" + null+ "\n"
                    +"   safe active:"+false+ "\n"
                    + "Room 102:\n" + "    rented by: " + room2.getGuest().toString()+"\n"
                    +"    safe active:  "+room2.getSafe().isActive();
        } else {
            return "Hotel Twente\n Room 101 "+"("+ROOM_PRICE+ "/night) :\n"
                    + "   rented by" +null + "\n"
                    +"   safe active:"+false+ "\n"
                    + "Room 102:\n" + "    rented by: " + null+"\n"
                    +"    safe active:  "+false;
        }
    }
}
