package ss.week1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ss.week1.Fibonacci;

public class FibonacciTest {
    @Test
    void fibonacciTest() {
        assertEquals(5, Fibonacci.fibonacci(5));
        assertEquals(3, Fibonacci.fibonacci(4));
        assertEquals(2, Fibonacci.fibonacci(3));
        assertEquals(1, Fibonacci.fibonacci(2));
        assertEquals(1, Fibonacci.fibonacci(1));
        assertEquals(0, Fibonacci.fibonacci(0));
        assertEquals(701408733, Fibonacci.fibonacci(44));
    }

    void BrolenfibonacciTest() {
        assertEquals(5, BrokenFibonacci.fibonacci(5));
        assertEquals(3, BrokenFibonacci.fibonacci(4));
        assertEquals(2, BrokenFibonacci.fibonacci(3));
        assertEquals(1, BrokenFibonacci.fibonacci(2));
        assertEquals(1, BrokenFibonacci.fibonacci(1));
        assertEquals(0, BrokenFibonacci.fibonacci(0));
        assertEquals(701408733, BrokenFibonacci.fibonacci(44));
    }
}
