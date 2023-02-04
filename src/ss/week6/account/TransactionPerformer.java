package ss.week6.account;

public class TransactionPerformer implements Runnable {
    private double amount;
    private int times;
    private static Account account;

    public TransactionPerformer(double amount, int times, Account account) {
        this.amount = amount;
        this.times = times;
        this.account = account;
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
        synchronized (account){
            while (times!=0) {
                while ((account.getBalance()+amount)<-1000){
                    try {
                        account.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                account.transaction(amount);
                account.notifyAll();
                times--;
            }

        }
    }
}
