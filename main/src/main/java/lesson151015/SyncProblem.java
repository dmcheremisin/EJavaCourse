package lesson151015;

import lesson151008.Utils;

/**
 * Created by dmitr on 05.10.2017.
 */
public class SyncProblem {

    public static void main(String[] args) {
        final Object mutex = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
                synchronized (mutex) { // mutex is free
                    System.out.println("synched in");
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                    System.out.println("woke up");
                }
                System.out.println("synched out");
            }
        });

        Utils.pause(1000);

        synchronized (mutex) {
            thread.start();
            thread.interrupt();
            while(true) {
                Utils.pause(1000);
            }
        }

    }
}
