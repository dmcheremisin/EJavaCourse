package lesson151029;

/**
 * @author dmch0916
 *         Date: 17.10.2017
 *         Time: 17:34
 */
public class CasCounter {

    private SimulateCompareAndSwap value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while ( v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }

}
