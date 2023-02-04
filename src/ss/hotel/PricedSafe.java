package ss.hotel;

import ss.hotel.bill.Bill;
import ss.hotel.password.BasicChecker;
import ss.hotel.password.Checker;
import ss.hotel.password.Password;
import ss.hotel.password.StrongChecker;

public class PricedSafe extends Safe implements Bill.Item{
    private double price;
    private Password password;
    private BasicChecker checker;

    /**
     *
     * @param price is price of the safe
     */
    //@requires price != 0.0;
    public PricedSafe(double price){
        assert  price > 0.0;
        this.price = price;
        checker = new BasicChecker();
        this.password = new Password(checker);
    }

    //@ensures \result==price;
    @Override
    public double getPrice() {
        return this.price;
    }

    //@ensures \result==password;
    public Password getPassword(){
        return  this.password;
    }

    //@requires text!=null;
    public void activate(String text) {
        assert text != null;
        if (getPassword().testWord(text)){
            super.activate();
        }else{
            System.out.print("incorrect password\n");
        }
    }


    @Override
    public void activate() {
        System.out.println("You need to put password");
    }

    @Override
    public void deactivate() {
        super.deactivate();
    }

    //@requires text!=null;
    public void open(String text) {
        assert text != null;
        if(isActive()&getPassword().testWord(text)){
            super.open();
        }else {
            System.out.println("incorrect pass or inactive");
        }

    }

    @Override
    public void open() {}

    @Override
    public void close() {
        super.close();
    }

    public String toString(){
        return "Priced safe: "+this.getPrice();
    }


    public static void main(String[] args) {
        PricedSafe pricedSafe = new PricedSafe(-12.1);

    }
}
