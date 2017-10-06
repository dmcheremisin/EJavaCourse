package lesson151015;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmitr on 06.10.2017.
 */
public class ScheduledThreadPools {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");
            }
        }, 0, 1, TimeUnit.SECONDS);

        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("!!!!!!!!!!1");
            }
        }, 10, TimeUnit.SECONDS);
    }
}
