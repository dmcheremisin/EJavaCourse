package lesson151029;

/**
 * @author dmch0916
 *         Date: 17.10.2017
 *         Time: 17:29
 */
public class SimulateCompareAndSwap {

    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if(oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }
}
