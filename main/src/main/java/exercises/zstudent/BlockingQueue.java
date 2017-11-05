package exercises.zstudent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dmitr on 04.10.2017.
 */
public class BlockingQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    private static final int MAX_SIZE = 2;

    public void put(T item) {
        System.out.println("Put item: " + item + ", size = " + queue.size());
        synchronized (queue) {
            while(queue.size() >= MAX_SIZE) {
                try {
                    System.out.println("Max size reached");
                    queue.wait();
                } catch (InterruptedException e) {
                    //ignore
                }
            }
            System.out.println("Continue put item " + item + ", size = " + queue.size());
            queue.offer(item);
            queue.notify();
        }
    }

    public T take() {
        System.out.println("Take item, size = " + queue.size());
        synchronized (queue) {
            while(queue.isEmpty()){
                try {
                    System.out.println("Queue is empty");
                    queue.wait();
                } catch (InterruptedException e) {
                    // ignore
                }
            }
            queue.notify();
            T poll = queue.poll();
            System.out.println("Take item = " + poll + ", size = " + queue.size());
            return poll;
        }
    }

    public int size() {
        return queue.size();
    }
}
