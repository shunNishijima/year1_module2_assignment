package ss.calculator;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ImplementRunnableCalculator implements Runnable {
    private StreamCalculator stream = new ImplementStreamCalculator();
    private Reader reader;
    private Writer writer;
    public ImplementRunnableCalculator(Reader reader,Writer writer){
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            this.stream.process(reader,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
