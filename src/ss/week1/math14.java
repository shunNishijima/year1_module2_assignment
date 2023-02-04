package ss.week1;

import java.util.Scanner;

public class math14 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        System.out.println("How many primes ?"+N);
        int i = 2;
        while(N>0){
            if(isPrime(i)){
                System.out.println(i);
                N--;
            }
            i++;
        }
        }

    public static boolean isPrime(int number) {
        int i = 2;
        while (i<number) {
            if (number % i == 0){
                return false;
            } else {
                i++;
            }
        }
        return true;
    }
}

