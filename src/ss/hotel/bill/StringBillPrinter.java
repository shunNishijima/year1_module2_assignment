package ss.hotel.bill;

public class StringBillPrinter extends SysoutBillPrinter{
    private String string="";
    @Override
    public void printLine(String text, double price) {
        string = string+super.format(text, price);
    }

    public String getResult(){
        return string;
    }}