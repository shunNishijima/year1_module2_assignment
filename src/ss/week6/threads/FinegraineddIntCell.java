package ss.week6.threads;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegraineddIntCell implements IntCell{
    private LinkedList<Integer> values = new LinkedList<>();
    final int capacity = 1;
    private static Lock l = new ReentrantLock();
    private Condition emp = l.newCondition();
    /**
     * @param val
     */
    @Override
    public void setValue(int val) {
        try{
            l.lock();
            while (values.size()==capacity) {
                emp.await();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        this.values.add(val);
        emp.signal();
        l.unlock();
        }
    /**
     * @return
     */
    @Override
    public int getValue() {
        try {
            l.lock();
            while (values.size() == 0) {
                emp.await();
            }
        }catch (InterruptedException e) {
                    e.printStackTrace();
        }
        int n = this.values.pop();
        emp.signal();
        l.unlock();
        return n;
    }
}