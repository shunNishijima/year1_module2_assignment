package ss.week1;

import java.util.Scanner;

import static java.lang.Math.*;

public class Math {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of sides : ");
        Integer n = input.nextInt();
        System.out.println("Enter the length of each side : ");
        Double s  = input.nextDouble();

        Double Area = (pow(s,2)*n) / (4*tan(PI/n));

        System.out.println("The area is : "+Area);
    }
}
