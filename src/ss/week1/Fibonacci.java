package ss.week1;

public class Fibonacci {
    public static void main(String[] args){
        System.out.println(fibonacci(23));
    }
    public static long fibonacci(int n){
        switch (n){
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
