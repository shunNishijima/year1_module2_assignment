package ss.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ss.calculator.*;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



class CalculatorTest {
    private static CalculatorFactory factory;

    @BeforeAll
    static void setup() {
        // static because a @BeforeAll must be a static method
        // therefore the field "factory" is also static

        factory = new ImplementCalculatorFactory();
    }

    @Test
    void testPushPop() throws StackEmptyException {
        var calculator = factory.makeCalculator();

        // Simple test: if we push the value 0.5, do we also get it back?
        calculator.push(0.5);
        assertEquals(0.5, calculator.pop());

        // Test a bunch of random numbers in a random order...
        List<Double> exampleNumbers = new ArrayList<>();
        var rand = new Random();
        for (int i=0; i<10; i++) {
            exampleNumbers.add(rand.nextDouble());
        }

        for (int i=0; i<10; i++) {
            calculator.push(exampleNumbers.get(i));
        }

        for (int i=9; i>=0; i--) {
            assertEquals(exampleNumbers.get(i), calculator.pop(), 0.01);
        }

        // Test exceptions
        assertThrows(StackEmptyException.class, () -> calculator.pop());
    }

    @Test
    void testAdd() throws StackEmptyException {
        var calculator = factory.makeCalculator();

        // Also test proper handling of the stack
        // after these, stack will be: { 100, 200, -100, -300 }
        // so the first add adds -100 and -300 (= -400)
        // and the second add adds 100 and 200 (= 300)
        calculator.push(100);
        calculator.push(200);
        calculator.push(-100);
        calculator.push(-300);
        calculator.add();
        assertEquals(-400, calculator.pop());
        calculator.add();
        assertEquals(300, calculator.pop());

        // Now add some numbers
        calculator.push(4);
        calculator.push(7);
        calculator.push(1);
        calculator.push(8);
        calculator.push(3);
        calculator.push(5);
        calculator.push(2);
        calculator.push(9);
        calculator.push(6);
        calculator.add();
        calculator.add();
        calculator.add();
        calculator.add();
        calculator.add();
        calculator.add();
        calculator.add();
        calculator.add();
        // adding 1+2+3+4+5+6+7+8+9 (in any order) = 45
        assertEquals(45, calculator.pop());
        assertThrows(StackEmptyException.class, () -> calculator.pop());
    }

    @Test
    void testSub() throws StackEmptyException {
        var calculator = factory.makeCalculator();

        // test if 100-0=100
        calculator.push(100);
        calculator.push(0);
        calculator.sub();
        assertEquals(100, calculator.pop());

        // test if 0-100=-100
        calculator.push(0);
        calculator.push(100);
        calculator.sub();
        assertEquals(-100, calculator.pop());
    }

    @Test
    void testMult() throws StackEmptyException {
        var calculator = factory.makeCalculator();

        calculator.push(5);
        calculator.push(9);
        calculator.mult();
        assertEquals(45, calculator.pop());
        assertThrows(StackEmptyException.class, () -> calculator.pop());
    }

    @Test
    void testDiv() throws StackEmptyException, DivideByZeroException {
        var calculator = factory.makeCalculator();

        // test if we get a divide by zero exception
        calculator.push(100);
        calculator.push(0);
        assertThrows(DivideByZeroException.class, () -> calculator.div());
        // after a divide by zero exception, the stack should be size 1 with only Double.NaN on top
        assertEquals(Double.NaN, calculator.pop());
        assertThrows(StackEmptyException.class, () -> calculator.pop());

        // now test a proper division 100/6
        calculator.push(100);
        calculator.push(6);
        calculator.div();
        assertEquals(100.0/6, calculator.pop());
        assertThrows(StackEmptyException.class, () -> calculator.pop()); // and test if stack now empty
    }

    @Test
    void testDup() throws StackEmptyException {
        var calculator = factory.makeCalculator();

        // Simple test: if we push the value 0.5, do we also get it back?
        calculator.push(0.5);
        calculator.dup();
        assertEquals(0.5, calculator.pop());
        assertEquals(0.5, calculator.pop());

        // Test exceptions
        assertThrows(StackEmptyException.class, () -> calculator.pop());
    }

    @Test
    void testMod() throws StackEmptyException, DivideByZeroException {
        var calculator = factory.makeCalculator();

        // test if we get a divide by zero exception
        calculator.push(100);
        calculator.push(0);
        assertThrows(DivideByZeroException.class, () -> calculator.div());
        // after a divide by zero exception, the stack should be size 1 with only Double.NaN on top
        assertEquals(Double.NaN, calculator.pop());
        assertThrows(StackEmptyException.class, () -> calculator.pop());

        // now test a proper division 100/6
        calculator.push(100);
        calculator.push(6);
        calculator.mod();
        assertEquals(100.0%6, calculator.pop());
        assertThrows(StackEmptyException.class, () -> calculator.pop()); // and test if stack now empty
    }
}
