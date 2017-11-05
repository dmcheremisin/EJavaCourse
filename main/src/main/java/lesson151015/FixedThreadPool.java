package lesson151015;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dmitr on 06.10.2017.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
