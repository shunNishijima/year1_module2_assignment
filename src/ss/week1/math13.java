package ss.week1;

import java.util.Scanner;

import static java.lang.Math.PI;
import static java.lang.Math.random;

public class math13 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Double N = input.nextDouble();
        System.out.println("Please enter the number of iterations :"+N);
        int n = 0;
        for(int i=0;i<N;i++) {
            Double x = random();
            Double y = random();
            if ((x * x) + (y * y) <= 1) {
                n++;
            }
        }

        Double pi = (4*n)/N;
        System.out.println("Estimation of pi :"+pi);
    }
}
