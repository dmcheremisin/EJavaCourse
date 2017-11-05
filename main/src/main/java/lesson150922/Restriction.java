package lesson150922;

import java.util.ArrayDeque;

/**
 * Created by dmitr on 17.08.2017.
 */
public class Restriction {
    static class MyClass extends ArrayDeque{
        @Override
        public void push(Object o) {
            addLast(o);
        }

        @Override
        public Object pop() {
            return removeLast();
        }

        @Override
        public void addFirst(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object removeFirst() {
            throw new UnsupportedOperationException();
        }
    }
}
