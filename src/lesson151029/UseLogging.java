package lesson151029;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author dmch0916
 *         Date: 17.10.2017
 *         Time: 12:57
 */
public class UseLogging {

    private static Logger logger;

    static {
        logger = new Logger();
        Thread thread = new Thread(logger);
        thread.setDaemon(true);
        thread.start();
    }

    static class Task implements Runnable {

        Random rand = new Random();
        int count;

        @Override
        public void run() {
            long start = System.nanoTime();
            while (count < 100_000_000) {
                count++;
                if (count % 1_000_000 == 0) {
                    logger.log(String.valueOf(count));
                }
            }
            long stop = System.nanoTime();
            System.out.println("Elapsed: " + (stop - start));
        }
    }

    static class Logger implements Runnable {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        @Override
        public void run() {
            while (true) {
                try {
                    String message = queue.take();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        public void log(String message) {
            try {
                queue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("start");
        new Task().run();
    }

}
