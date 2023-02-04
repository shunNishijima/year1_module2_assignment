package ss.week1;

import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

import static java.lang.Math.*;

public class Math10 {
    public static void main(String[] args){
        Double c;
        Scanner input = new Scanner(System.in);
        System.out.println("What is the amount borrowed ? ");
        Double P = input.nextDouble();
        System.out.println("What is the yearly interest rate ( in %)? ");
        Double r  = input.nextDouble()/1200;
        System.out.println("What is the number of years ? ");
        Double N = 12*input.nextDouble();


        if (r==0){
            c = P/N;
        }else{
            c = (r*P)/(1-pow((1+r),-N));
        }

        Long nc = round(c);
        System.out.println("The monthly payment is "+ nc);
    }
}
