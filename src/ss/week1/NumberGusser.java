package ss.week1;

import java.util.Scanner;

import static java.lang.Math.random;
import static java.lang.Math.round;

public class NumberGusser {
    public static void main(String[] args){
        Long random = round(random()*100);
        System.out.println(random);
        Scanner input = new Scanner(System.in);
        System.out.println("Guess number? ");
        Long n = input.nextLong();
        while (random != n){
            if(random>n){
                System.out.println("too Low");
            }else {
                System.out.println("too High");
            }
            System.out.println("Guess again? ");
            n = input.nextLong();
        }
        System.out.println("You are Correct!");
    }
}
