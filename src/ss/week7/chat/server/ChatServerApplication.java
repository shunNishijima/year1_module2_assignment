package ss.week7.chat.server;
import java.util.Scanner;

public class ChatServerApplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ChatServer server = new ImplChatServer();
            server.start();
        System.out.println("port number is: "+server.getPort());
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
