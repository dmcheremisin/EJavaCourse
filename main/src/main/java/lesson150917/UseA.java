package lesson150917;

/**
 * Created by dmitr on 10.08.2017.
 */
public class UseA {
    public static void main(String[] args) {
        A.staticMethod();
        A a = new A();
        A.staticMethod(a);
    }

}
