package lesson151008;

/**
 * Created by dmitr on 02.10.2017.
 */
public class StackOverflowExample {

    public static void main(String[] args) {
        a();
    }

    private static void a() {
        int x = 0;
        a();
    }
}
