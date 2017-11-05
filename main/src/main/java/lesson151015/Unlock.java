package lesson151015;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dmitr on 05.10.2017.
 */
public class Unlock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.unlock(); // Illegal monitor state
            }
        }).start();
    }
}
