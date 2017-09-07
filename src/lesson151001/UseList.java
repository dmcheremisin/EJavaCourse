package lesson151001;

import java.util.Iterator;

/**
 * @author dmch0916
 *         Date: 06.09.2017
 *         Time: 19:10
 */
public class UseList {

    public static void main(String[] args) {
        MyList<String> list = new MyList<String>(){{
           add("one");
           add("two");
           add("three");
        }};

        for (String item : list) {
            System.out.println(item);
        }

        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }

        System.out.println("================");
        Iterator<String> it1 = list.iterator();
        System.out.println(it1.next());
        System.out.println(it1.next());

        Iterator<String> it2 = list.iterator();
        System.out.println(it1.next());

    }
}
