package ss.week1;

import java.util.Scanner;

import static ss.week1.math14.*;

public class emirp {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("How many emirps ?");
        int N = input.nextInt();

        int j = 0;
        int i = 12;
        while (j<N){
            if(isEmirp(i)){
                System.out.print(" " +i);
                j++;
            }
            i++;
        }
    }
    public static int reverse(int number){
        String snumber = Integer.toString(number);
        char[] chars = snumber.toCharArray();
        char [] rchars = new char[chars.length];
        int j = 0;
        int i = chars.length -1;
        while(i>=0){
            rchars[j] = chars[i];
            j++;
            i--;
        }
        int n = Integer.parseInt(new String(rchars));
        return n;
    }
    public static boolean isEmirp(int number){
        if(isPrime(number)&&isPrime(reverse(number))&&number!=reverse(number)){
            return true;
        }else{
            return false;
        }
    }
}
