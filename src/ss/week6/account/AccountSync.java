package ss.week6.account;

import java.util.concurrent.TimeUnit;

public class AccountSync {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        new Thread(new TransactionPerformer(12,9998,account),"Thread 1").start();
        new Thread(new TransactionPerformer(-12,9999,account),"Thread 2").start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(account.getBalance());
    }
}
