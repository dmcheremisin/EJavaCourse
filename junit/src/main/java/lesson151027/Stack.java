package lesson151027;

/**
 * @author dmch0916
 *         Date: 08.09.2017
 *         Time: 17:57
 */
public class Stack<T> {

    T[] data;
    private int next;

    public Stack(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException();
        }
        data = (T[]) new Object[maxSize];
    }

    public void push(T item) throws Exception {
        if (next == data.length) {
            throw new Exception("Overflow index=" + next + ", size=" + data.length);
        }
        data[next++] = item;
    }

    public T pop() throws Exception {
        if (next == 0) {
            throw new Exception("Underflow");
        }
        T datum = data[--next];
        data[next] = null;
        return datum;
    }

}
