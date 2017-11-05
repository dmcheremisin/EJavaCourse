package lesson151029;

import lesson151008.Utils;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Dmitrii on 18.10.2017.
 */
public class Sprinter implements Runnable{

    static Random rand = new Random();
    private CyclicBarrier barrier;

    public Sprinter(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(this + " starts walking ");
        Utils.pause(rand.nextInt(5000) + 3000);
        System.out.println(this + " finished and waits others");
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(this + " finally free");
    }
}
