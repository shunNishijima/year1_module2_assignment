package ss.hotel.bill;

public interface BillPrinter {
    public String format(String text, double price);
    public void printLine(String text, double price);
}
