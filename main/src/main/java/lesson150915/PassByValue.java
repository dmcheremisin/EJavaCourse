package lesson150915;

/**
 * Created by dmitr on 09.08.2017.
 */
public class PassByValue {
    public static void main(String[] args) {
        int x = 10;
        change(x);
        System.out.println(x);
    }

    private static void change(final int x) {
        // x = 20; ERROR
    }
}
