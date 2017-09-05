package lesson150922;

/**
 * Created by dmitr on 17.08.2017.
 */
public class Extension {

    static class Dog {

    }

    static class HuntDog extends Dog {

        public void trackFox(){
            System.out.println("tracking fox");
        }
    }
}
