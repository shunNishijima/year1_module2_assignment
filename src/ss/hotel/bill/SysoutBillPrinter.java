package ss.hotel.bill;

public class SysoutBillPrinter implements BillPrinter{

    @Override
    public String format(String text,double price) {
        return String.format("%1$-25s%2$10.2f",text,price)+"\n";
    }

    @Override
    public void printLine(String text, double price) {
        System.out.println(format(text,price));
    }

    public static void main(String[] args) {
        SysoutBillPrinter p = new SysoutBillPrinter();
        p.printLine("Text1",1.0);
        p.printLine ("Other text", -12.1212);
        p.printLine ("Something", .2);

    }
}
