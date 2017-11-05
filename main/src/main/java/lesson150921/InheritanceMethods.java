package lesson150921;

/**
 * Created by dmitr on 13.08.2017.
 */
public class InheritanceMethods {

    static class A{
        static String method(){
            return "A";
        }
        int calc() {
            return 4;
        }
    }

    static class B extends A {
        static String method(){
            return "B";
        }
        int calc() {
            return 10;
        }
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.method());
        System.out.println(a.calc());

        B b = new B();
        System.out.println(b.method());
        System.out.println(b.calc());

        A a1 = new B();
        System.out.println(a1.method());
        System.out.println(a1.calc());
    }
}
