package ss.hotel.bill;

public class Bill {
    private BillPrinter billPrinter;
    private double sum;

    public static interface Item {
        public double getPrice();

        String toString();
    }

    public Bill(BillPrinter billPrinter) {
        this.billPrinter = billPrinter;
    }

    public void addItem(Bill.Item item) {
        billPrinter.printLine(item.toString(), item.getPrice());
        this.sum = this.sum + item.getPrice();
    }

    public void close() {
        billPrinter.printLine("total bill", getSum());
    }

    public double getSum() {
            return this.sum;
    }
}
