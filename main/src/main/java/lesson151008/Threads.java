package lesson151008;

/**
 * Created by dmitr on 02.10.2017.
 */
public class Threads {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());

        new Thread() {
            @Override
            public void run() {
                Thread currentThread = Thread.currentThread();
                System.out.println(currentThread);
                for (StackTraceElement el : currentThread.getStackTrace()) {
                    System.out.println(el.getClassName() + " "  + el.getMethodName() + " " + el.getLineNumber());
                }
            }
        }.start();
    }
}
