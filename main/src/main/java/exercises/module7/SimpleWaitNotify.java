package exercises.module7;

import lesson151008.Utils;

/**
 * Created by Dmitrii on 19.11.2017.
 */
public class SimpleWaitNotify {
    static final Object trigger = new Object();

    static class InnerClass implements Runnable {
        Object trigger;
        int name;

        public InnerClass(Object trigger, int name) {
            this.trigger = trigger;
            this.name = name;
        }

        @Override
        public void run() {
            Utils.pause(500);
            while(true) {
                System.out.println(name + " : inside run ");
                synchronized (trigger) {
                    try {
                        System.out.println(name +  " : waiting ");
                        trigger.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            System.out.println(name + " : finished waiting ");
        }
    }

    public static void main(String[] args) {
        Thread[] ths = new Thread[5];
        for (int i = 0; i < 5; i++ ){
            ths[i] = new Thread(new InnerClass(trigger, i+1));
        }
        for (Thread th : ths) {
            th.start();
        }
        Utils.pause(1000);
        synchronized (trigger){
            trigger.notifyAll();
        }

    }
}























