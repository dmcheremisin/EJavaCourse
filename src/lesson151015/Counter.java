package lesson151015;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dmitr on 05.10.2017.
 */
public class Counter {

    private int count;
    //private Object lock = new Object();

    private Lock lock = new ReentrantLock();

    public void inc(){
//        synchronized (lock) {
//            count++;
//        }
        lock.lock(); // lock
        try {
            count++; // do work
        } finally {
            lock.unlock(); // unlock
        }
    }

    public int get() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
//        synchronized (lock) {
//            return count;
//        }
    }

}
