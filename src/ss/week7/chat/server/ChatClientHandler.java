package ss.week7.chat.server;

import ss.week7.chat.Protocol;

import java.io.*;
import java.net.Socket;

public class ChatClientHandler implements Runnable{
    private Socket socket;
    private ChatServer chatServer;
    private String username;
    public ChatClientHandler(Socket socket,ChatServer cs){
        this.socket = socket;
        this.chatServer = cs;
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
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            username = line;
            //System.out.println(line);
            String[] splits;
            while (true){
                if((line=br.readLine())==null){
                    close();
                    chatServer.stop();
                    break;
                } else if (!(line.startsWith("SAY~"))) {
                    System.out.println("invalid format");
            }else {
                    splits = line.split("~");
                    //System.out.println(line);
                    chatServer.handleChatMessage(this,splits[1]);
                    //System.out.println("reach here");
                }
            }
            br.close();
        } catch (IOException e) {
            close();
            chatServer.stop();
            e.printStackTrace();
        }
    }
    public void sendChat(String from,String message){
        try{
            //System.out.println(message);
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            printWriter.println(Protocol.forwardMessage(from,message));
            printWriter.flush();
        } catch (IOException e) {
            close();
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getUsername(){
        return this.username;
    }

}
