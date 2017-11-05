package lesson151013;

import lesson151008.Utils;

import java.util.Date;
import java.util.Random;

/**
 * Created by dmitr on 04.10.2017.
 */
public class UseBlockingQueue {

    static Random random = new Random();

    static class Producer implements Runnable {
        private BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while(true) {
                Utils.pause(2000 + random.nextInt(3000));
                queue.put(new Date().toString());
                System.out.println("Produced item, total: " + queue.size());
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while(true) {
                Utils.pause(3000 + random.nextInt(3000));
                String item = queue.take();
                System.err.println(item + " сonsumed, total: " + queue.size());
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> queue = new BlockingQueue<>();
        new Thread(new Consumer(queue)).start();
        new Thread(new Producer(queue)).start();
    }
}
