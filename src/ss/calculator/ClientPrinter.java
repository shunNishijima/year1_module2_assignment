package ss.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class ClientPrinter implements Runnable{
    private BufferedReader inputStream;
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

    public ClientPrinter(BufferedReader inputStream){
        this.inputStream = inputStream;
    }
    @Override
    public void run() {
        String line;
        try {
            while ((line = inputStream.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
