package lesson151008;

/**
 * Created by dmitr on 02.10.2017.
 */
public class Example2 {
    static class Task implements Runnable {
        @Override
        public void run() {
            int i = 0 ;
            while(true) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Task()).start();
        new Thread(new Task()).start();
    }
}
