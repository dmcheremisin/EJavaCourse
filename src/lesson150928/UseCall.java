package lesson150928;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static lesson150928.Call.CITY_COMPARATOR;

/**
 * @author dmch0916
 *         Date: 01.09.2017
 *         Time: 13:07
 */
public class UseCall {

    public static void main(String[] args) {
        Call call = new Call();
        call.city = "Moscow";

        List<Call> calls = new LinkedList<>();
        calls.add(Call.register("Amsterdam", 17, 45));
        calls.add(Call.register("Moscow", 10, 30));
        calls.add(Call.register("Moscow", 19, 30));
        calls.add(Call.register("Samara", 11, 20));
        calls.add(Call.register("Samara", 22, 20));
        calls.add(Call.register("NY", 2, 00));
        calls.add(Call.register("Minsk", 9, 10));
        calls.add(Call.register("Minsk", 23, 40));
        calls.add(Call.register("Vladivostok", 16, 40));
        Collections.sort(calls, (o1, o2) -> o1.city.compareTo(o2.city));
        System.out.println(calls);
        Collections.sort(calls);
        System.out.println(calls);
        Collections.sort(calls, CITY_COMPARATOR);
        System.out.println(calls);
    }

}
