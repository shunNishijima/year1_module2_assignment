package ss.week7.chat.client;

import java.net.InetAddress;
import java.util.List;

public interface ChatClient extends Runnable{
    boolean connect(InetAddress address, int port);
    void close();
    boolean sendUsername(String username);
    boolean sendMessage(String message);
    void addChatListener(ChatListener chatListener);
    void removeChatListener(ChatListener chatListener);
}
