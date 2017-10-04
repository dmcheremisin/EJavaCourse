package exercises.zstudent;

import lesson151008.Utils;

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
                Utils.pause(2000);
            }
        }
    }

    static class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Task name: " + name + " is running");
        }

        @Override
        public String toString() {
            return name;
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
        worker.execute(new Task("1"));
        worker.execute(new Task("2"));
        worker.execute(new Task("3"));
        worker.execute(new Task("4"));
    }
}
