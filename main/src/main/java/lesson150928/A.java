package lesson150928;

/**
 * @author dmch0916
 *         Date: 01.09.2017
 *         Time: 18:08
 */
public class A {

    static class S {

    }

    public A(){
        this.new B();//equivalent
        new B();
    }

    class B {

    }
}
