package ss.calculator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ImplementCalculatorServer implements CalculatorServer {
    private ServerSocket ss;
    private Thread t1;
    /**
     * Start the server on the given port in a separate thread
     *
     * @param port the desired port (or 0 to take any available TCP port)
     * @throws IOException if the port was not available or there was some other I/O problem
     */
    @Override
    public void start(int port) throws IOException {
        ss = new ServerSocket(port);
        t1 = new Thread(this,"T1");
        t1.start();
    }

    /**
     * Get the port that the server is running on
     *
     * @return the port number
     */
    @Override
    public int getPort() {
        return ss.getLocalPort();
    }

    /**
     * Stop the server and return after the thread has stopped
     */
    @Override
    public void stop() {
        try{
            ss.close();
            t1.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
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
            Socket s = ss.accept();

            ClientHandler ch = new ClientHandler(s);
            new Thread(ch,"T2").start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
