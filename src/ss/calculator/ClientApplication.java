package ss.calculator;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("What is server address?");
            String address = s.nextLine();
            System.out.println("What is port number?");
            int port = s.nextInt();

            Socket socket = new Socket(address, port);

            PrintWriter pw2 = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ClientPrinter cp = new ClientPrinter(br);
            new Thread(cp,"t3").start();
            System.out.println("Write Command");
            String line;
            while ((line = s.nextLine())!=null){
                if(line.equals("quit")){
                    socket.close();
                    break;
                } else if (line.equals("")) {
                }else{
                    pw2.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
