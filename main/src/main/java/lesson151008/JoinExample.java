package lesson151008;

/**
 * Created by dmitr on 02.10.2017.
 */
public class JoinExample {
    public static void main(String[] args) {
        System.out.println("start");

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finish");
    }
}
