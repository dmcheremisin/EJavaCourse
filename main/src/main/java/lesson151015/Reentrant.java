package lesson151015;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dmitr on 05.10.2017.
 */
public class Reentrant {

    void a(){
        synchronized (this) {
            synchronized (this) { // mutex this is reentrant
                System.out.println("inside b");
            }
        }
    }

    void c() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            lock.lock();
            try {
                System.out.println("Here, count=" + lock.getHoldCount());
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Reentrant reentrant = new Reentrant();
        reentrant.a();
        reentrant.c();
    }
}
