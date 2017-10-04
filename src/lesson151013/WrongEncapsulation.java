package lesson151013;

import lesson151008.Utils;

import java.util.Vector;

/**
 * Created by dmitr on 04.10.2017.
 */
public class WrongEncapsulation {
    public static void main(String[] args) {
        final Vector<String> vector = new Vector<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    vector.addElement("one");
                    System.out.println(vector);
                    Utils.pause(1000);
                    vector.removeElementAt(0);
                    System.out.println(vector);
                    Utils.pause(1000);
                }
            }
        }).start();

        Utils.pause(5000);

        synchronized (vector) { // blocks vector forever
            while(true) {
                Utils.pause(1000);
                System.out.println("xexe");
            }
        }
    }
}
