package ss.calculator;

import java.io.*;
import java.util.Scanner;

public class ServerApplication {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter port number");
        int port = -1;
        try{
            while (!(port >= 0 && port <= 65536)) {
                port = s.nextInt();
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        CalculatorFactory factory = new ImplementCalculatorFactory();
        CalculatorServer server = factory.makeCalculatorServer();
        try{
            server.start(port);
            System.out.println("port number is: "+server.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("type something");
        boolean bool=true;
        while (bool) {
            String line;
            if ((line = s.nextLine()).equals("quit")) {
                server.stop();
                bool = false;
            }
        }

    }
}
