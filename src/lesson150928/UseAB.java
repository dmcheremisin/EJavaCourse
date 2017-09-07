package lesson150928;

/**
 * @author dmch0916
 *         Date: 01.09.2017
 *         Time: 18:08
 */
public class UseAB {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();

        A.S s = new A.S();
    }

}
