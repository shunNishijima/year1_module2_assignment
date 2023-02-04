package ss.calculator;

import java.util.Stack;

public class ImplementCalculator implements Calculator {

    private Stack<Double> stack = new Stack<Double>();
    @Override
    public void push(double value) {
        this.stack.push(value);
    }

    @Override
    public double pop() throws StackEmptyException {

        if (this.stack.size()==0) {
            throw new StackEmptyException("stack empty");
        }

        return this.stack.pop();
    }

    @Override
    public void add() throws StackEmptyException {
        if (this.stack.size()<2) {
            throw new StackEmptyException("stack empty");
        }

        //for this im not sure if the elements used for adding are supposed to remain on stack, for now I leave it like this
       Double d1 =  this.stack.pop();
       Double d2 = this.stack.pop();
       this.stack.push(d1+d2);
    }

    @Override
    public void sub() throws StackEmptyException {
        if (this.stack.size()<2) {
            throw new StackEmptyException("stack empty");
        }


            Double d1 = this.stack.pop();
            Double d2 = this.stack.pop();
            this.stack.push(d2 - d1);


    }


    @Override
    public void mult() throws StackEmptyException {
        if (this.stack.size()<2) {
            throw new StackEmptyException("stack empty");
        }
        Double d1 =  this.stack.pop();
        Double d2 = this.stack.pop();
        this.stack.push(d1*d2);

    }

    @Override
    public void div() throws DivideByZeroException, StackEmptyException {

        if (this.stack.size()<2) {
            throw new StackEmptyException("stack empty");
        }
        Double d1 =  this.stack.pop();
        Double d2 = this.stack.pop();
        if(d1 == 0.0){
            this.stack.push(Double.NaN);
            throw new DivideByZeroException("cannot divide by 0");
        }else {

        this.stack.push(d2/d1);}
    }



    @Override
    public void dup() throws StackEmptyException
    {
        if (this.stack.size()<1){
            throw new StackEmptyException("the stack is empty");
        }
        Double d = this.stack.pop();
        this.stack.push(d);
        this.stack.push(d);
    }
//xd
    @Override
    public void mod() throws DivideByZeroException, StackEmptyException {
        if (this.stack.size()<2) {
            throw new StackEmptyException("stack empty");
        }
        Double d1 =  this.stack.pop();
        Double d2 = this.stack.pop();
        if(d1 == 0.0){
            this.stack.push(Double.NaN);
            throw new DivideByZeroException("cannot divide by 0");
        }else {

            this.stack.push(d2%d1);}
    }
}
