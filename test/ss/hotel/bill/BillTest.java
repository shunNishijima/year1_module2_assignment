package ss.hotel.bill;
import static java.lang.Double.sum;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BillTest {

    private double sum;
    private Bill bill;
    public BillPrinter billPrinter;
    public BillTest.Item item1 = new Item("Coca-cola",30.00);
    public BillTest.Item item2 = new Item("shirt",100.00);


    public class Item implements Bill.Item{
        String text;
        double price;
        public Item(String text, Double price){
            this.text =text;
            this.price = price;
        }
        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return text;
        }
    }


    @BeforeEach
    public void setUp(){
        billPrinter = new StringBillPrinter();
        bill = new Bill(billPrinter);
    }

    @Test
    public void  testEmpty(){
        assertEquals(0.0,bill.getSum());
        assertTrue(((StringBillPrinter) billPrinter).getResult()=="");
    }

    @Test
    public void testaddItem(){
        bill.addItem(item1);
        assertEquals(30.00,bill.getSum());
        assertTrue(((StringBillPrinter) billPrinter).getResult().contains(item1.toString()));
    }

    @Test
    public void testClose(){
        bill.addItem(item1);
        bill.addItem(item2);
        bill.close();
        assertTrue(((StringBillPrinter) billPrinter).getResult().contains(billPrinter.format("total bill",sum(item1.getPrice(),item2.getPrice()))));
    }
}
