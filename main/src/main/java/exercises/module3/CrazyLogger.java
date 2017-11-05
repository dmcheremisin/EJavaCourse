package exercises.module3;

import lesson151008.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dmitrii on 05.11.2017.
 */
public class CrazyLogger {

    private static final Object mutex = new Object();
    private static StringBuilder sb = new StringBuilder();

    public static synchronized void log(String message) {
        synchronized (mutex) {
            Date date = new Date();
            sb.append("\n\r");
            SimpleDateFormat df = new SimpleDateFormat("dd-mm-YYYY : hh-mm – ");
            String dateString = df.format(date);
            sb.append(dateString).append(message);
        }
    }

    public static String getLog() {
        synchronized (mutex){
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        CrazyLogger.log("hello");
        Utils.pause(1000);
        CrazyLogger.log("good bye");
        System.out.println(getLog());
    }
}
