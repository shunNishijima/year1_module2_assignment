package ss.week1;

import java.util.Arrays;
import java.util.Scanner;

public class splitNumber {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter some numbers :");
        String s = scan.nextLine();
        String[] split = s.split("\\s+");
        Integer [] intSplit = new Integer[split.length];
        for (int i=0;i<split.length;i++){
            intSplit[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(intSplit);
        for (int i =0;i< intSplit.length; i++){
            System.out.print(intSplit[i]);
        }

    }
}
