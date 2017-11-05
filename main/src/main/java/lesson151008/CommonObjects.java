package lesson151008;

/**
 * Created by dmitr on 02.10.2017.
 */
public class CommonObjects {

    static class Data {
        int x = 20;
    }

    public static void main(String[] args) {
        Data data = new Data();

        a(data);
    }

    private static void a(Data d) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(d.x);
            }
        }.start();
    }
}
