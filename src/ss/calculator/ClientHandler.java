package ss.calculator;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Calculator calculator;
    private Socket s;

    /**
     * constructor of calculator
     */
    public ClientHandler(Socket s){
        this.calculator = new ImplementCalculator();
        this.s = s;
    }
    /**
     * Process all commands read from the given input, and write the result(s) to the given output
     *
     * @param input  the Reader to read commands from
     * @param output the Writer to write output to
     */
    public void process(Reader input, Writer output) throws IOException {
        BufferedReader br;
        PrintWriter pw;

        br = new BufferedReader(input);
        pw = new PrintWriter(output);
        String line;
        String[] split;

        while ((line=br.readLine())!=null) {
            try {
                split = line.split(" ");
                switch (split[0]) {
                    case "":
                        pw.println("error: blank");
                        pw.flush();
                        break;
                    case "push":
                        if (split.length == 1) {
                            pw.println("error: push");
                            pw.flush();
                        } else {
                            try{
                                calculator.push(Double.parseDouble(split[1]));
                            } catch (NumberFormatException e) {
                                pw.println("error:  push");
                                pw.flush();
                                e.printStackTrace();
                            }
                        }
                        break;
                    case "pop":
                        pw.println(calculator.pop());
                        pw.flush();
                        break;
                    case "add":
                        calculator.add();
                        break;
                    case "sub":
                        calculator.sub();
                        break;
                    case "mult":
                        calculator.mult();
                        break;
                    case "div":
                        calculator.div();
                        break;
                    case "dup":
                        calculator.dup();
                        break;
                    case "mod":
                        calculator.mod();
                        break;
                    default:
                        pw.println("error: else");
                        pw.flush();
                        break;
                }
            } catch (StackEmptyException | DivideByZeroException e) {
                pw.println("error:  exception");
                pw.flush();
                e.printStackTrace();
            }
        }
        try {
            br.close();
            pw.close();
        }catch (IOException e){
            e.printStackTrace();}
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
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

            this.process(br, pw);

            pw.flush();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
