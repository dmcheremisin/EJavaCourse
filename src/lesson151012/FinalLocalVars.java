package lesson151012;

import lesson151008.Utils;

/**
 * Created by dmitr on 04.10.2017.
 */
public class FinalLocalVars {



    public static void main(String[] args) {
        final int x = 10; // outer.x

        new Thread(new Runnable() {
            @Override
            public void run() {
                Utils.pause(3000);
                // int x = outer.x;
                System.out.println("x = " + x);
            }
        }).start();

        System.out.println("finished");
    }
}
