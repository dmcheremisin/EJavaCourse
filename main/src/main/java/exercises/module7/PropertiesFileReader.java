package exercises.module7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Dmitrii on 19.11.2017.
 */
public class PropertiesFileReader {
    static Map<String, Map<String, String>> filesMap = new HashMap<>();

    private static class SyncFileReader implements Runnable {
        PropertiesFileReader pfr;
        String fileName;

        public SyncFileReader(PropertiesFileReader pfr, String fileName) {
            this.pfr = pfr;
            this.fileName = fileName;
        }

        @Override
        public void run() {
            synchronizedReading(pfr, fileName);
        }
    }

    public static void main(String[] args) {

        PropertiesFileReader fileReader = new PropertiesFileReader();
        String questions = "questions_en.properties";
        String answeres = "answers1_en.properties";
        startThreads(fileReader, questions, 4);
        startThreads(fileReader, answeres, 5);
    }

    private static void startThreads(PropertiesFileReader fileReader, String fileName, int count) {
        Thread[] th = new Thread[count];
        for (int i = 0; i < count; i++) {
            th[i] = new Thread(new SyncFileReader(fileReader, fileName));
            th[i].start();
        }
    }

    private static void synchronizedReading(PropertiesFileReader fileReader, String fileName) {
        synchronized (filesMap) {
            Map<String, String> propertiesMap = filesMap.get(fileName);
            if (propertiesMap == null) {
                System.out.println(" =============== NEW FILE ==================== ");
                try {
                    propertiesMap = openAndRead(fileReader, fileName);
                    filesMap.put(fileName, propertiesMap);
                    printProperties(propertiesMap);
                } catch (FileNotFoundException e) {
                    // put empty map in order not to read file, which doesn't exists, several times
                    filesMap.put(fileName, new HashMap<>());
                    System.err.println(e.getClass());
                    System.err.println(e.getMessage());
                }
            } else {
                System.out.println(" =============== FILE HAS ALREADY BEEN READ =============== ");
                printProperties(propertiesMap);
            }
        }
    }

    private static Map<String, String> openAndRead(PropertiesFileReader fileReader, String fileName)
            throws FileNotFoundException {
        try {
            String filePath = fileReader.getClass().getClassLoader().getResource(fileName).getFile();
            return readFile(fileName, filePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(" FILEPATH ERROR:  " + fileName);
            throw new FileNotFoundException(" ========== File: " + fileName + " is not found! ============= ");
        }
    }

    private static void printProperties(Map<String, String> propertiesMap) {
        if (propertiesMap.isEmpty()) {
            System.out.println(" =============== EMPTY PROPERTIES ============= ");
        } else {
            for (String key : propertiesMap.keySet()) {
                System.out.println(key + " => " + propertiesMap.get(key));
            }
        }
    }

    private static Map<String, String> readFile(String fileName, String filePath) {
        Map<String, String> propertiesMap = new LinkedHashMap<>();
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            System.out.println(" ============== Reading ==============");
            while ((line = br.readLine()) != null) {
                String[] split = line.split("=");
                String key = split[0].trim();
                String value = split[1].trim();
                System.out.println(key + " => " + value);
                propertiesMap.put(key, value);
            }
            System.out.println(" ============== FINISHED ==============");
        } catch (Exception e) {
            System.out.println("Can't read file:  " + fileName);
        }
        return propertiesMap;
    }
}

















