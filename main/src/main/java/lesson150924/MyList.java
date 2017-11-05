package lesson150924;

/**
 * Created by dmitr on 30.08.2017.
 */
public class MyList<T> {

    Node<T> first;
    Node<T> last;

    public void add(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        if (first == null) {
            first = node;
            node.next = last;
            last = node;
            return;
        }
        last.next = node;
        last = node;
    }

    @Override
    public String toString() {
        String s = "[";
        Node tmp = first;
        while(tmp != null) {
            s += tmp.data;
            s += ", ";
            tmp = tmp.next;
        }
        s += "]";
        return s;
    }
}
