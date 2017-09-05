package lesson150917;

/**
 * Created by dmitr on 10.08.2017.
 */
public class A {

    private int x;
    private static int globalCount = 0;

    public A() {
        this(-1);
        globalCount++;
    }

    public A(int x) {
        this.x = x;
    }

    public static void staticMethod() {
        System.out.println("static");
        // x=10; ERROR static
        System.out.println(globalCount);
    }


    public static void staticMethod(A a) {
        a.x = 10;
        staticMethod();
    }


}
