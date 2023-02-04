package ss.week1;

import java.util.Scanner;

public class Math11 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your income ? ");
        Double I = input.nextDouble();
        Double tax;
        if (I<35472){
            tax = 0.0942*I;
        } else if (I>69398) {
            tax = 15917+(0.4950*(I-69398));
        }else {
            tax = 3341+(0.3707*(I -35472));
        }
        System.out.println("Your income tax is "+tax);
}}
