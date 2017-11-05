package lesson151012;

import lesson151008.Utils;

/**
 * Created by dmitr on 04.10.2017.
 */
public class Deadlock {

    static public class Human{

    }

    static class Ogre {
        private Human human1;
        private Human human2;

        public Ogre(Human h1, Human h2) {
            human1 = h1;
            human2 = h2;
        }

        public void snack() {
            synchronized (human1) {
                eatLeg(human1);
                synchronized (human2) {
                    eatLeg(human2);
                }
            }
        }

        private void eatLeg(Human human) {
            System.out.println("Ogre " + this + "eats leg of " + human);
            Utils.pause(1000);
            System.out.println("Ogre " + this + " finished eat leg of " + human);
        }
    }

    public static void main(String[] args) {
        Human h1 = new Human();
        Human h2 = new Human();

        Ogre ogre1 = new Ogre(h1, h2);
        Ogre ogre2 = new Ogre(h2, h1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ogre1.snack();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ogre2.snack();
            }
        }).start();

    }
}
