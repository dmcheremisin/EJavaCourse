package lesson151015;

import lesson151008.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dmitr on 05.10.2017.
 */
public class UseRunners {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();

        Runner runner1 = new Runner(lock, condition);
        Runner runner2 = new Runner(lock, condition);
        Runner runner3 = new Runner(lock, condition);

        Thread thread1 = new Thread(runner1, "Runner1");
        Thread thread2 = new Thread(runner2, "Runner2");
        Thread thread3 = new Thread(runner3, "Runner3");

        thread1.start();
        thread2.start();
        thread3.start();

        Utils.pause(1000);

        lock.lock();
        try {
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }
}
