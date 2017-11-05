package lesson150917;

/**
 * Created by dmitr on 10.08.2017.
 */
public class B {

    static {
        System.out.println("static");
    }

    {
        System.out.println("instance");
    }

    public B() {
        System.out.println("constructor");
    }


}
