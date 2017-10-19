package lesson151029;

import lesson151008.Utils;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Dmitrii on 19.10.2017.
 */
public class SyncQueueExample {
    static Random random = new Random();

    static class Chef implements Runnable {

        private SynchronousQueue<String> window;

        public Chef(SynchronousQueue<String> window) {
            this.window = window;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("cooking...");
                Utils.pause(5000 + random.nextInt(5000));
                System.out.println("ready...");
                try {
                    window.put("Tartar");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiter implements Runnable {

        private SynchronousQueue<String> window;

        Waiter(SynchronousQueue<String> window) {
            this.window = window;
        }

        @Override
        public void run() {
            while(true){
                try {
                    System.err.println("waiting...");
                    String dish = window.take();
                    System.err.println(dish);
                    Utils.pause(5000 + random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        SynchronousQueue<String> window = new SynchronousQueue<>();
        ex.execute(new Chef(window));
        ex.execute(new Waiter(window));
        ex.shutdown();


    }

}


