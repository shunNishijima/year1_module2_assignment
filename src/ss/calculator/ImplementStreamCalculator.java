package ss.calculator;

import java.io.*;

public class ImplementStreamCalculator implements StreamCalculator{
    private Calculator calculator;

    /**
     * constructor of calculator
     */
    public ImplementStreamCalculator(){
        this.calculator = new ImplementCalculator();
    }
    /**
     * Process all commands read from the given input, and write the result(s) to the given output
     *
     * @param input  the Reader to read commands from
     * @param output the Writer to write output to
     */
    @Override
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
                         pw.println("error: ");
                         pw.flush();
                         break;
                     case "push":
                         if (split.length == 1) {
                             pw.println("error: ");
                             pw.flush();
                         } else {
                             try{
                             calculator.push(Double.parseDouble(split[1]));
                             } catch (NumberFormatException e) {
                                 pw.println("error:  ");
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
                         pw.println("error: ");
                         pw.flush();
                         break;
                 }
             } catch (StackEmptyException | DivideByZeroException e) {
                 pw.println("error:  ");
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
}
