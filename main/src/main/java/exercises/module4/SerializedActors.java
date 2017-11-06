package exercises.module4;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dmitrii on 06.11.2017.
 */
public class SerializedActors implements Serializable {
    public static final String FILE = "C:\\Workspace\\EpamJava\\out\\actors.txt";
    public List<String> actors = new ArrayList<>();

    public static void main(String[] args) {
        File file = new File(FILE);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(FILE)) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                SerializedActors sa = (SerializedActors) ois.readObject();
                sa.actors.add("New Actor" + new Date());
                sa.actors.forEach(System.out::println);
                writeObject(sa);
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            writeObject(new SerializedActors());
        }

    }

    private static void writeObject(SerializedActors sa) {
        try (FileOutputStream fos = new FileOutputStream(FILE)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sa);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
