package lesson150922.interfaces;

/**
 * Created by dmitr on 17.08.2017.
 */
public class GarbageCollector {
    public static void main(String[] args) {
        Car car = new Car();
        Table table = new Table();

        collectGarbage(car, table);
    }

    private static void collectGarbage(Crashable... crashables) {
        for (Crashable crashable : crashables) {
            crashable.crash();
        }
    }
}
