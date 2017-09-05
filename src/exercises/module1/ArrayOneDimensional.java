package exercises.module1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitr on 20.08.2017.
 */
public class ArrayOneDimensional {
    static List<Integer> arr = new ArrayList<>();
    static List<Integer> newArr = new ArrayList<>();
    static int count = 20;

    public static void main(String[] args) {
        populateArray();
        findMax();
    }

    private static void findMax() {
        int max = newArr.get(0);
        for (Integer num : newArr) {
            if(num > max) {
                System.out.println(max);
                max = num;
            }
        }
        System.out.println("Max = " + max);
    }

    private static void populateArray() {
        int twiceCount = count * 2;
        for (int i = 0; i < twiceCount; i++){
            int p = (int) (Math.tan(i)  + Math.random() * 10);
            arr.add(p);
        }
        int j;
        for(int i = 0; i < count; i++) {
            j = twiceCount - i - 1;
            int sum = arr.get(i) + arr.get(j);
            newArr.add(sum);
            System.out.println(sum);
        }
    }
}
