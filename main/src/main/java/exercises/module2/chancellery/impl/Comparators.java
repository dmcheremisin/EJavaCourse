package exercises.module2.chancellery.impl;

import exercises.module2.chancellery.Nameable;
import exercises.module2.chancellery.Priceable;

import java.util.Comparator;

/**
 * @author dmch0916
 *         Date: 21.08.2017
 *         Time: 18:02
 */
public class Comparators {

    public static Comparator<Priceable> getPriceComparator() {

        return new Comparator<Priceable>() {
            @Override
            public int compare(Priceable o1, Priceable o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        };
    }

    public static Comparator<Nameable> getNameComparator() {

        return new Comparator<Nameable>() {
            @Override
            public int compare(Nameable o1, Nameable o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }

}