package ss.week7.chat.client;

import ss.week7.chat.Protocol;

public class Listener implements ChatListener{
    private ChatClient chatClient;

    /**
     * @param from
     * @param message
     */
    @Override
    public void messageReceived(String from, String message) {
        System.out.println(message);
    }
}
