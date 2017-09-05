package lesson150922;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by dmitr on 17.08.2017.
 */
public class Construction {

    static class MyStack extends ArrayDeque{

        public void push(Object o) {
            addLast(o);
        }
        public Object pop() {
            return removeLast();
        }
    }

    public static void main(String[] args) {
        Deque d = new MyStack();
        process(d);
    }

    private static void process(Deque d) {
        d.push("one");
        d.push("two");
        d.push("three");
        System.out.println(d.removeFirst());
    }

}
