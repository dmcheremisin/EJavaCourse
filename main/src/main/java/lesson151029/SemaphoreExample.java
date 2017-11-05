package lesson151029;

import lesson151008.Utils;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Dmitrii on 19.10.2017.
 */
public class SemaphoreExample {

    static Random random = new Random();

    static class Skater implements Runnable {
        private Semaphore sem;

        Skater(Semaphore sem) {
            this.sem = sem;
        }

        @Override
        public void run() {
            System.out.println("starts");
            Utils.pause(random.nextInt(5000) + 5000);
            System.out.println("finished");
            sem.release();
        }
    }

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(5);
        ExecutorService ex = Executors.newCachedThreadPool();
        while (true) {
            sem.acquireUninterruptibly();
            ex.execute(new Skater(sem));
        }
    }

}
