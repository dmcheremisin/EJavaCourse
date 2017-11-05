package lesson151001;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dmch0916
 *         Date: 08.09.2017
 *         Time: 12:26
 */
public class StringMap {
    private static final int CAPACITY = 10;

    static class Entry {
        String key;
        String value;
        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    List<Entry>[] data;

    public StringMap() {
        this.data = new List[CAPACITY];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void put(String key, String value) {
        char c = key.charAt(0);
        int index = c % CAPACITY;
        List<Entry> datum = data[index];
        datum.add(new Entry(key, value));
    }

    public String get(String key) {
        char c = key.charAt(0);
        int index = c % CAPACITY;
        for (Entry entry : data[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        StringMap map = new StringMap();
        map.put("Pete", "12433423432");
        map.put("John", "62433423432");
        map.put("Ann", "92433423432");
        System.out.println(map.get("Pete"));
        System.out.println(map.get("John"));
        System.out.println(map.get("Ann"));
        map.put("Paul", "777777");
        System.out.println(map.get("Pete"));
        System.out.println(map.get("Paul"));
    }
}
