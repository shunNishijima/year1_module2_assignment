package ss.week1;

import java.util.Scanner;

public class GrossAndDozen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer n = input.nextInt();
        Number gross = n / 144;
        Integer rest = n % 144;
        Number dozen = rest / 12;
        Number and = rest % 12;
        System.out.println("Your number of eggs is " + gross + "gross , " + dozen + " dozen , and " + and);
    }
}
