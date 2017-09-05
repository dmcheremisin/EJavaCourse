package lesson150924;

/**
 * Created by dmitr on 30.08.2017.
 */
public class UseMyList {

    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        //list.add(10);
        System.out.println(list);
    }
}
