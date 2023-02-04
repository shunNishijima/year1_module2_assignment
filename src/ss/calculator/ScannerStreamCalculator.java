package ss.calculator;

import java.io.*;
import java.util.Scanner;

public class ScannerStreamCalculator {
    private static CalculatorFactory factory;
    private static StreamCalculator streamCalculator;


    public static void main(String[] args) throws IOException {
        factory = new ImplementCalculatorFactory();
        streamCalculator = factory.makeStreamCalculator();

        try {
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(input);
            PrintStream output = new PrintStream(System.out);
            PrintWriter pr = new PrintWriter(output);

            streamCalculator.process(br,pr);

        } catch (Exception e) {
        
        }
    }
}
