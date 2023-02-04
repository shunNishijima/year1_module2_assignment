package ss.week6.threads;

public class GoodIntCell implements IntCell{
    int value;
    private boolean bool;
    /**
     * @param val
     */
    @Override
    public void setValue(int val) {

        synchronized (this){
            while (bool){
                try{
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            value = val;
            bool = true;
            this.notifyAll();
        }
    }
    /**
     * @return
     */
    @Override
    public int getValue() {
        synchronized (this) {
            while (!bool) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int n = value;
            this.notifyAll();
            bool = false;
            return n;
        }
    }
}
