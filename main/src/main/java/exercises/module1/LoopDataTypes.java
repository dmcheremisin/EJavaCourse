package exercises.module1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitr on 20.08.2017.
 */
public class LoopDataTypes {
    public static List<Double> numbers = new ArrayList<>();

    public static void addNumbers() {
        for (int i = 1; i < 1000; i++) {
            double a = 1 / Math.pow((i+1), 2);
            numbers.add(a);
        }
    }


    public static void main(String[] args) {
        addNumbers();
        findLowest(0.00005);
    }

    private static void findLowest(double epsilon) {
        int size = numbers.size();
        for (int i = 0; i < size; i++){
            Double aDouble = numbers.get(i);
            if (aDouble < epsilon ) {
                System.out.println(i);
                break;
            }
        }
    }
}
