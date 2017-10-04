package lesson151013;

import lesson151008.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dmitr on 04.10.2017.
 */
public class WorkerThreadWithBlockingQueue {

    private Thread thread;
    private BlockingQueue<Runnable> tasks = new BlockingQueue<>();

    private final class TaskRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                Runnable task = tasks.take();
                task.run();
            }
        }
    }

    public WorkerThreadWithBlockingQueue() {
        thread = new Thread(new TaskRunner());
        thread.start();
    }

    private void execute(Runnable runnable) {
        tasks.put(runnable);
    }

    public static void main(String[] args) {
        System.out.println("Start");
        WorkerThreadWithBlockingQueue worker = new WorkerThreadWithBlockingQueue();
        Utils.pause(3000);
        worker.execute(new Runnable(){
            @Override
            public void run() {
                System.out.println("hello from " + Thread.currentThread().getName());
            }
        });
        Utils.pause(3000);
        worker.execute(new Runnable(){
            @Override
            public void run() {
                System.out.println("another hello from " + Thread.currentThread().getName());
            }
        });
    }
}
