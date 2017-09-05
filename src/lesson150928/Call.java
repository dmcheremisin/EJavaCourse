package lesson150928;

import java.util.Comparator;

/**
 * @author dmch0916
 *         Date: 01.09.2017
 *         Time: 13:04
 */
public class Call implements Comparable<Call>{


    String city;
    Time time;

    static class CityComparator<T extends Call> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.city.compareTo(o2.city);
        }
    }
    public static final Comparator<Call> CITY_COMPARATOR = new CityComparator<>();

    public static Call register(String city, int hour, int minutes) {
        Call call = new Call();
        call.city = city;
        call.time = new Time();
        call.time.hour = hour;
        call.time.minutes = minutes;
        return call;
    }

    @Override
    public int compareTo(Call o) {
        if (this.time.hour == o.time.hour) {
            return this.time.minutes - o.time.minutes;
        }
        return this.time.hour - o.time.hour;
    }

    private static class Time {
        int hour;
        int minutes;

    }

    @Override
    public String toString() {
        return city + ", " + time.hour + ":" + time.minutes;
    }
}
