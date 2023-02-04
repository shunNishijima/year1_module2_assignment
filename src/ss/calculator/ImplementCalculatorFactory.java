package ss.calculator;

import java.io.Reader;
import java.io.Writer;

public class ImplementCalculatorFactory implements CalculatorFactory{

    @Override
    public Calculator makeCalculator() {
        return new ImplementCalculator();
    }

    @Override
    public StreamCalculator makeStreamCalculator() {
        return new ImplementStreamCalculator();
    }

    @Override
    public Runnable makeRunnableStreamCalculator(Reader reader, Writer writer) {
        return new ImplementRunnableCalculator(reader,writer);
    }

    @Override
    public CalculatorServer makeCalculatorServer() {
        return new ImplementCalculatorServer();
    }
}
