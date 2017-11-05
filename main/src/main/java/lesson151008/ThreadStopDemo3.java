package lesson151008;

/**
 * Created by dmitr on 03.10.2017.
 */
public class ThreadStopDemo3 {
    static class Task implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                    break;
                }
            }
            System.out.println("stopped!");
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
        Utils.pause(5000);
        System.out.println("stopping");
        thread.interrupt();
    }
}
