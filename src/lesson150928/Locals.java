package lesson150928;

/**
 * @author dmch0916
 *         Date: 01.09.2017
 *         Time: 18:55
 */
// local class example
public class Locals {

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello!");
        }
    }

    public static Runnable createTask() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi there!");
            }
        };
    }

    public static Runnable[] tasks() {
        class MyTask implements Runnable {
            String text;
            public MyTask(String text) {
                this.text = text;
            }
            @Override
            public void run() {
                System.out.println(text);
            }
        }
        Runnable[] myTasks = {new MyTask("first"),new MyTask("second"), new MyTask("third")};
        return myTasks;
    }

    public static void main(String[] args) {
        createTask().run();
        new Task().run();
    }
}
