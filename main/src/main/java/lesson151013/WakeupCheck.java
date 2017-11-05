package lesson151013;
import lesson151008.Utils;

/**
 * Created by dmitr on 04.10.2017.
 */
public class WakeupCheck {

    public static void main(String[] args) {
        final Object starter = "stater";

        class Runner implements Runnable {
            boolean started;

            @Override
            public void run() {
                synchronized (starter) {
                    System.out.println(Thread.currentThread() + " waiting for signal");
                    while(!started) {
                        try {
                            starter.wait(); // starter is free now!
                        } catch (InterruptedException e) {
                            System.err.println("woke up! are we started?");
                        }
                    }
                }
                System.out.println("running!");
            }
            public void start() {
                synchronized (starter) {
                    starter.notify();
                    started = true;
                }
            }
        }
        Runner runner = new Runner();
        Thread thread = new Thread(runner);
        thread.start();

        Utils.pause(3000);
        thread.interrupt();

        Utils.pause(3000);
        runner.start();
    }
}
