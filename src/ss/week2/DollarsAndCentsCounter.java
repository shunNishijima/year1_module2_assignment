package ss.week2;

/**
 * This class records an amount of money as dollars and cents.
 */
public class DollarsAndCentsCounter {
    /**@
     * private invariant totalcents >=0;
     * private invariant totaldollars >=0;
     */

    /*@ spec_public */ private int totalcents;
    /*@ spec_public */private int totaldollars;

    /**
     * Return the amount of getDollars.
     * @return the amount of getDollars
     */
    //@ requires totaldollars>=0;
    //@ ensures \result >= 0;
    public int getDollars() {
        return totaldollars;
    }

    /**
     * Return the amount of cents.
     * @return the amount of cents
     */
    //@ requires totalcents>0;
    //@ ensures \result >= 0 && \result < 100;
    public int getCents() {
        return totalcents;
    }

    /**
     * Add the specified amount of dollars and cents to this counter.
     * @param dollars the amount of dollars to add
     * @param cents the amount of cents to add
     */
    /*@
       requires dollars >=0 && cents >=0;
    */
    //@ ensures getCents() >= 0 && getDollars()>=0 &&getCents()<100;
    //@ ensures getDollars() * 100 + getCents() ==\old(getDollars() * 100 + getCents()) + dollars * 100 + cents;
    public void add(int dollars, int cents) {
        int adddollars = cents/100;
        cents = cents%100;
        totalcents = totalcents + cents;
        if(totalcents>=100){
            totaldollars = totaldollars+getCents()/100;
            totalcents = totalcents%100;
        }
        totaldollars = totaldollars + dollars +adddollars;
    }

    /**
     * Reset this counter to 0.
     */
    //@ requires totaldollars >=0 && totalcents >=0;
    //@ ensures getDollars() == 0 && getCents() == 0;
    public void reset() {
        totalcents = 0;
        totaldollars = 0;
    }
}
