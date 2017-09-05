package lesson150921;

/**
 * Created by dmitr on 13.08.2017.
 */
public class InheritanceConstructor {

    static class A {
        A (int x) {
            System.out.println("x=" + x);
        }
    }

    static class B extends A {
        B() {
            super(10);
        }
    }

    public static void main(String[] args) {
        B b = new B();
    }
}
