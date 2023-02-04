package ss.week1;

import java.util.Scanner;

public class Phone {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a word :");
        String s = input.nextLine();
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        int[] out = new int[arr.length];
        for(int i=0; i<arr.length;i++){
            switch (arr[i]){
                case 'a': case 'b': case 'c':
                    out[i] = 2;
                    break;
                case 'd': case 'e': case 'f':
                    out[i] = 3;
                    break;
                case 'g': case 'h': case 'i':
                    out[i] = 4;
                    break;
                case 'j': case 'k': case 'l':
                    out[i] = 5;
                    break;
                case 'm': case 'n': case 'o':
                    out[i] = 6;
                    break;
                case 'p': case 'q': case 'r': case 's':
                    out[i] = 7;
                    break;
                case 't': case 'u': case 'v':
                    out[i] = 8;
                    break;
                case 'w': case 'x': case 'y': case 'z':
                    out[i] = 9;
                    break;

            }
        }
        for (int i=0;i<out.length;i++) {
            System.out.print(out[i]);
        }
    }
}
