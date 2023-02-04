package ss.week6.threads;

public class TestConsole implements Runnable{
    private static String input = "";
    private TestConsole(){}

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
        sum();
    }

    private static void sum(){
        System.out.print(Thread.currentThread().getName()+" ");
        System.out.print("get number 1?");
        int n1 = Console.readInt(input);
        System.out.print(Thread.currentThread().getName()+" ");
        System.out.print("get number 2?");
        int n2 = Console.readInt(input);
        System.out.print(Thread.currentThread().getName()+" ");
        Console.println(n1+" + "+n2+ " = "+ (n1 + n2));
    }

    public static void main(String[] args) {
        new Thread(new TestConsole(),"Thread Exam2.A:").start();
        new Thread(new TestConsole(),"Thread B:").start();
    }
}



