package lesson151008;

/**
 * Created by dmitr on 03.10.2017.
 */
public class ThreadStopDemo {

    static class Task implements Runnable {
        private volatile boolean stopped;

        @Override
        public void run() {
            long i = 0;
            while(!stopped){
                i++;
            }
            System.out.println(i);
        }
        public void stop(){
            stopped = true;
        }
    }

    public static void main(String[] args) {
        System.out.println("START");
        Task task = new Task();
        new Thread(task).start();
        Utils.pause(5000);
        task.stop();
        System.out.println("FINISH");
    }

}
