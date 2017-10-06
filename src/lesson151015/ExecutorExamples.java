package lesson151015;

import lesson151008.Utils;

import java.util.concurrent.*;

/**
 * Created by dmitr on 06.10.2017.
 */
public class ExecutorExamples {

    static class Task implements Callable<Double>{
        @Override
        public Double call() throws Exception {
            double d = 0;
            for (int i = 0; i < 1_000_000_000; i++){
                d += Math.pow(Math.PI, Math.E);
            }
            return d;
        }
    }

    public static void main(String[] args) {

        ExecutorService worker = Executors.newSingleThreadExecutor();
        worker.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi there!");
            }
        });
        try {
            Future<Double> future = worker.submit(new Task());
            worker.shutdown();
            System.out.println("waiting for result");
            while(!future.isDone()) {
                Utils.pause(1000);
                System.out.println("waiting...");
            }
            Double aDouble = future.get();
            System.out.println(aDouble);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
