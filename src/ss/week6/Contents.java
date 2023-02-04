package ss.week6;

import java.util.concurrent.TimeUnit;

public class Contents {
    private int contents = 0;

    public void add(int amount) {
        contents = contents + amount;
    }
    public int get() {
        return contents;
    }

    public static void main(String[] args) throws InterruptedException {
        Contents cell = new Contents();
        Thread a1 = new Thread(new Adder(cell, 1));
        Thread a2 = new Thread(new Adder(cell, 2));
        a1.start();
        a2.start();
        //TimeUnit.SECONDS.sleep(1);
        try {
            a1.join();
            a2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cell.get());
    }
}

class Adder implements Runnable {
    private Contents cell;
    private int amount;

    public Adder(Contents cellArg, int amountArg) {
        this.cell = cellArg;
        this.amount = amountArg;
    }
    public synchronized void run() {
            cell.add(amount);
    }
}
