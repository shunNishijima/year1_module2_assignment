package ss.week7.chat.client;

import ss.week7.chat.Protocol;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client implements ChatClient {
    private Socket socket;
    private List<ChatListener> chatListeners = new ArrayList<>();
    private PrintWriter writer;
    private String username;

    /**
     * @param address
     * @param port
     * @return
     */
    @Override
    public boolean connect(InetAddress address, int port) {
        try {
            socket = new Socket(address, port);
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println(port);
            new Thread(this).start();
            return true;
        } catch (IOException e) {
            System.out.println("port or host is wrong");
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     */
    @Override
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param username
     * @return
     */
    @Override
    public boolean sendUsername(String username) {
        this.username = username;
        writer.println(username);
        writer.flush();
        return true;
    }

    /**
     * @param message
     * @return
     */
    @Override
    public boolean sendMessage(String message) {//"Hello" UI Hello
        writer.println(Protocol.printMessage(message));//Say Hi
        writer.flush();
        return true;
    }

    /**
     * @param chatListener
     */
    @Override
    public void addChatListener(ChatListener chatListener) {
        chatListeners.add(chatListener);
    }

    /**
     * @param chatListener
     */
    @Override
    public void removeChatListener(ChatListener chatListener) {
        chatListeners.remove(chatListener);
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (chatListeners) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;

                sendUsername(username);
                while ((line = br.readLine()) != null) {

                    for (ChatListener chatListener : chatListeners) {
                        chatListener.messageReceived(username, line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
