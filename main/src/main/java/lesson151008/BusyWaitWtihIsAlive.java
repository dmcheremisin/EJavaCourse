package lesson151008;

/**
 * Created by dmitr on 03.10.2017.
 */
public class BusyWaitWtihIsAlive {

    static class Task implements Runnable {
        @Override
        public void run() {
            Thread.currentThread().setName(Task.class.getCanonicalName());
            for (long i = 0; i < 100_000_000_000L; i++){}
        }
    }

    public static void main(String[] args) {
        System.out.println("Start");

        Thread thread = new Thread(new  Task());
        thread.start();

        int c = 0;
        while(thread.isAlive()) {
            System.out.println(c++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finish");
    }
}
