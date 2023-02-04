package ss.hotel;

import ss.hotel.bill.Bill;

public class PricedRoom extends Room implements Bill.Item {
    private double ppp;


    public PricedRoom(int number,double price, double safeprice) {
        super(number,new PricedSafe(safeprice));
        this.ppp = price;
    }

    @Override
    public double getPrice() {
        return this.ppp;
    }

    @Override
    public String toString() {
        return super.toString()+" price: "+ppp;
    }
}
