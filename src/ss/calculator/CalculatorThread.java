package ss.calculator;

import java.io.*;

public class CalculatorThread {

    public static void main(String[] args) throws IOException {
        ImplementCalculatorFactory factory = new ImplementCalculatorFactory();
        PipedReader pr = new PipedReader();
        PipedWriter pw = new PipedWriter(pr);
        PrintWriter print = new PrintWriter(pw, true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        new Thread(factory.makeRunnableStreamCalculator(pr,new PrintWriter(System.out)),"Thread 1").start();
        while ((line=br.readLine())!=null){
            print.println(line);
        }

    }
}
