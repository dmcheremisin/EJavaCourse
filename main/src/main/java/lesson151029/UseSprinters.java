package lesson151029;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Dmitrii on 18.10.2017.
 */
public class UseSprinters {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(4);

        executor.execute(new Sprinter(barrier));
        executor.execute(new Sprinter(barrier));
        executor.execute(new Sprinter(barrier));
        executor.execute(new Sprinter(barrier));

        System.out.println("all started");
        executor.shutdown();

    }
}
