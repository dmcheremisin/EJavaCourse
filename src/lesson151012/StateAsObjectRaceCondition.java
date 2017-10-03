package lesson151012;

import lesson151008.Utils;

/**
 * Created by dmitr on 03.10.2017.
 */
public class StateAsObjectRaceCondition {

    static class A {
        int x = 0;
        int y = 100;
    }

    static class B {
        A a = new A();

        synchronized public A get() {
            return a;
        }

        synchronized public void change(int amount) {
            System.out.println("start change");
            Utils.pause(3000);
            a.x += amount;
            Utils.pause(3000);
            a.y -= amount;
            Utils.pause(3000);
            System.out.println("finish change");
        }
    }

    public static void main(String[] args) {
        B b = new B();
        A a = b.get();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("a.x = " + a.x + " a.y = " + a.y);
                    Utils.pause(500);
                }
            }
        }).start();

        b.change(20);
    }
}
