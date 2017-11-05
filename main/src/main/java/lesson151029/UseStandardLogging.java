package lesson151029;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dmch0916
 *         Date: 17.10.2017
 *         Time: 12:57
 */
public class UseStandardLogging {

    static Logger logger = Logger.getLogger("myTest");

    static class Task implements Runnable {

        int count;

        @Override
        public void run() {
            long start = System.nanoTime();
            while (count < 100_000_000) {
                count++;
                if (count % 1_000_000 == 0) {
                    //System.out.println(count);
                    logger.info(count + "");
                }
            }
            long stop = System.nanoTime();
            System.out.println("Elapsed: " + (stop - start));
        }
    }


    public static void main(String[] args) {
        try {
            logger.addHandler(new FileHandler("console.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //logger.setLevel(Level.SEVERE);

        System.out.println("start");
        new Task().run();
    }

}
