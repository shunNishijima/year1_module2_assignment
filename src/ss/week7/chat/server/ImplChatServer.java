package ss.week7.chat.server;

import ss.calculator.ClientHandler;
import ss.week7.chat.client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ImplChatServer implements ChatServer{
    private ServerSocket serverSocket;
    private Thread thread;
    private  int port;
    private static List<ChatClientHandler> clients = new ArrayList<>();
    private static boolean bool = false;
    /**
     * Starts the server. The server should run in a separate thread, so this method should return after starting this
     * thread. The server port depends on the implementation, for example, the port can be given in the constructor.
     * This method may only be run once.
     */
    @Override
    public void start() {
        try{
            serverSocket = new ServerSocket(port);
            thread = new Thread(this,"T1");
            thread.start();
            bool = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns the port of the server. This method returns the actual port the server is accepting connections on.
     *
     * @return the port number, between 0 and 65535.
     */
    @Override
    public int getPort() {
        return serverSocket.getLocalPort();
    }

    /**
     * Stops the server. This method returns after the server thread has actually stopped.
     * This method may only be run once and only after start() has been called before.
     */
    @Override
    public void stop() {
        try{
            serverSocket.close();
            thread.join();
            bool = false;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns true if the server is currently accepting connections, and false otherwise.
     */
    @Override
    public boolean isAccepting() {
        return bool;
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
        synchronized (clients){
            try{
                while(!serverSocket.isClosed()) {
                    Socket socket = serverSocket.accept();
                    ChatClientHandler chatClientHandler = new ChatClientHandler(socket, this);
                    clients.add(chatClientHandler);
                    new Thread(chatClientHandler, "T2").start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void handleChatMessage(ChatClientHandler from, String message){
        for (ChatClientHandler client : clients) {
            client.sendChat(from.getUsername(), message);
        }
    }
}
