package lesson151008;

/**
 * Created by dmitr on 03.10.2017.
 */
public class Deamons {

    static class Ticker implements Runnable {
        @Override
        public void run() {
            int x= 0;
            while(true){
                System.out.println(x++);
                Utils.pause(1000);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("start");
        Thread thread = new Thread(new Ticker());
        thread.setDaemon(true);
        thread.start();

        new Thread(){
            @Override
            public void run() {
                Utils.pause(10000);
            }
        }.start();
        Utils.pause(5000);

        System.out.println("finish");
    }
}
