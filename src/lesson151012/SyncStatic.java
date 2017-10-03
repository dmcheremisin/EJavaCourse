package lesson151012;

/**
 * Created by dmitr on 03.10.2017.
 */
public class SyncStatic {

    private static long count;

    synchronized public static long getCount() {
        return count;
    }

    synchronized public void inc() {
        count++;
    }

    public static void inc(int amount) {
        synchronized (SyncStatic.class) {
            count += amount;
        }
    }
}
