package ss.week7.chat.client;

import ss.week7.chat.Protocol;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your address?");
        String address = scanner.nextLine();
        System.out.println("What is your port number?");
        int port = scanner.nextInt();
        while (true){
            if(!(port>=0&&port<=65535)) {
                System.out.println("What is your port number again?");
                port = scanner.nextInt();
            }else{
                break;
            }
        }
        System.out.println("What is your name?");
        Scanner s = new Scanner(System.in);
        String username = s.nextLine();
        if(!username.equals("")) {
            ChatClient chatClient = new Client();
            ChatListener chatListener = new Listener();
            chatClient.addChatListener(chatListener);
            try {
                chatClient.connect(InetAddress.getByName(address), port);
            } catch (UnknownHostException e) {
                System.out.println("port or host is wrong");
                e.printStackTrace();
            }
            chatClient.sendUsername(username);
        while (true) {
            String message = s.nextLine();
            if (message.equals("quit")) {
                chatClient.close();
                break;
            } else {
                chatClient.sendMessage(message);
                System.out.println(Protocol.printMessage(message));
            }
        }
        }
    }
}
