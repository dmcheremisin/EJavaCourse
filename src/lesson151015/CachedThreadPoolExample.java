package lesson151015;

import lesson151008.Utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by dmitr on 06.10.2017.
 */
public class CachedThreadPoolExample {
    static class Task implements Callable<Double> {
        @Override
        public Double call() throws Exception {
            Thread.currentThread().setName("Task");
            double d = 0;
            for (int i = 0; i < 1_000_000; i++) {
                d += Math.pow(Math.PI, Math.E);
            }
            System.out.println("finished");
            return d;
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool(new ThreadFactory() {
            int count = 0;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread #" + count++);
            }
        });
        for (int i = 0; i < 10; i++) {
            service.submit(new Task());
            Utils.pause(1000);
        }
        for (int i = 0; i < 10; i++) {
            service.submit(new Task());
            Utils.pause(100);
        }
        service.shutdown();
    }

}
