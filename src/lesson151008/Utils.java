package lesson151008;

/**
 * Created by dmitr on 03.10.2017.
 */
public class Utils {

    public static void pause(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
