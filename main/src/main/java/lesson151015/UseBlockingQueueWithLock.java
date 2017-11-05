package lesson151015;

import lesson151008.Utils;

/**
 * Created by dmitr on 05.10.2017.
 */
public class UseBlockingQueueWithLock {
    public static void main(String[] args) {
        BlockingQueueWithLock<String> queue = new BlockingQueueWithLock<>(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                queue.put("one");
                System.out.println("put");
                Utils.pause(2000);
                queue.put("two");
                System.out.println("put");
                Utils.pause(2000);
                queue.put("three");
                System.out.println("put");
                Utils.pause(2000);
                queue.put("four");
                System.out.println("put");
                Utils.pause(2000);
                queue.put("five");
                System.out.println("put");
                Utils.pause(2000);
            }
        }).start();
        Utils.pause(1000);
        while(true) {
            Utils.pause(3000);
            System.out.println("taken: " + queue.take());
        }
    }
}