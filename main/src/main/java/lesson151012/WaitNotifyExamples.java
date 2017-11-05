package lesson151012;

import lesson151008.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitr on 04.10.2017.
 */
public class WaitNotifyExamples {

    static class Runner implements Runnable {
        private Object trigger;
        private String name;

        public Runner(Object trigger, String name) {
            this.trigger = trigger;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(this + " I'm ready to run!");
            synchronized (trigger) {
                try {
                    trigger.wait();
                    System.out.println(this + " awaken ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Utils.pause(1000);
            }
            while (true) {
                Utils.pause(1000);
                System.out.println(this + " running ");
            }
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        System.out.println("prepare runners ");
        List<Runner> runners = new ArrayList<>();
        Object trigger = new Object();
        runners.add(new Runner(trigger, "1"));
        runners.add(new Runner(trigger, "2"));
        runners.add(new Runner(trigger, "3"));
        runners.add(new Runner(trigger, "4"));

        for (Runner runner : runners) {
            new Thread(runner).start();
        }

        Utils.pause(1000);
        System.out.println("ready....");;
        Utils.pause(1000);
        System.out.println("steady....");
        Utils.pause(1000);
        System.out.println("GO!!!");
        synchronized (trigger) {
            trigger.notify();
            System.out.println("notified");
            Utils.pause(1000);
        }
    }
}