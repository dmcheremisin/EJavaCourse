package lesson150922.inheritance.vs.composition;

/**
 * Created by dmitr on 19.08.2017.
 */
public class Composition {
    static class A {
        void doIt() {
            System.out.println(this.getClass().getSimpleName() + " is working");
        }
    }
    static class B extends A {}
    static class C {
        A a = new A();
        void doIt(){
            a.doIt();
        }
    }
    static class D {
        A a;
        public D(A a) {
            this.a = a;
        }
        void doIt(){
            a.doIt();
        }
    }
    static class E {
        A a;
        public void setA(A a) {
            this.a = a;
        }
        void doIt () {
            a.doIt();
        }
    }
    static class F {
        void doIt(A a) {
            a.doIt();
        }
    }
    public static void main(String[] args) {
        A a = new A();        a.doIt();
        B b = new B();        b.doIt();
        C c = new C();        c.doIt();
        D d = new D(b);       d.doIt();
        E e = new E();        e.setA(a);        e.doIt();
        F f = new F();        f.doIt(b);
    }
}
