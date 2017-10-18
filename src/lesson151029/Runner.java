package lesson151029;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Dmitrii on 18.10.2017.
 */
public class Runner implements Runnable {

    private CountDownLatch latch;

    public Runner(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Runner " + this + " awaits");
        try {
            latch.await();
            System.out.println("Runner " + this + " runs");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
