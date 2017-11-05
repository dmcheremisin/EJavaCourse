package lesson150924;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * @author dmch0916
 *         Date: 30.08.2017
 *         Time: 18:55
 */
public class GenericsExamples {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(10);
        list.add("Hello");

        List<String> listOfStrings = Collections.checkedList(new LinkedList<String>(), String.class);
        //List<String> listOfStrings = new LinkedList<String>();
        listOfStrings.add("hello");
        //listOfStrings.add(10); ERROR

        List t = listOfStrings;
        //t.add(10);

        List<String> menu = Arrays.asList("Steak", "Fri", "Chicken");
        //List<String> menu2 = Arrays.asList(10, 20, 30); ERROR
        List<String> menu2 = new ArrayList<>();
        menu2.add("One");
        menu2.add("Two");
        menu2.add("Three");
        //print(menu); ERROR unmodifiable list
        print(menu2);

        menu2 = Collections.unmodifiableList(menu2);
        print(menu2);

    }

    private static void print(List<String> menu) {
        menu.add("Potato");
        System.out.println(menu);
    }
}