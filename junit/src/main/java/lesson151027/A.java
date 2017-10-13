package lesson151027;

/**
 * Created by Dmitrii on 13.10.2017.
 */
public class A {

    Crashable c;

    public A(Crashable c) {
        this.c = c;
    }

    public void destroy() {
        c.crash();
        c.crash();
    }
}
