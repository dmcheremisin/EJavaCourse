package lesson151029;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Dmitrii on 18.10.2017.
 */
public class NoECS {
    static Random rand = new Random();
    private static final int N = 10000;

    static class Task implements Callable<Double> {
        @Override
        public Double call() throws Exception {
            double r = 0;
            for (int i = 0; i < rand.nextInt(1000000); i++) {
                r += Math.pow(Math.E, Math.PI);
            }
            return r;
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2);
//        List<Future<Double>> futures = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            Future<Double> f = service.submit(new Task());
//            futures.add(f);
//        }
//
//        for (Future<Double> future : futures) {
//            try {
//                Double r = future.get();
//                System.out.println(r);
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }

        CompletionService<Double> ecs = new ExecutorCompletionService<>(service);
        for (int i = 0; i < N; i++) {
            ecs.submit(new Task());
        }

        for (int i = 0; i < N; i++) {
            try {
                Double r = ecs.take().get();
                System.out.println(r);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();

    }
}
