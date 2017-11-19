package exercises.module6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Dmitrii on 19.11.2017.
 */
public class PropertiesFileReader {

    public static void main(String[] args) {
        PropertiesFileReader pfr = new PropertiesFileReader();
        System.out.println("Input *.properties file name: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine() + ".properties";
        Map<String, String> propertiesMap = new HashMap<>();
        try {
            String filePath = pfr.getClass().getClassLoader().getResource(fileName).getFile();
            try(FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr)) {
                String line;
                while((line = br.readLine()) != null) {
                    String[] split = line.split("=");
                    String key = split[0].trim();
                    String value = split[1].trim();
                    propertiesMap.put(key, value);

                }
            } catch (Exception e) {
                System.out.println("Can't read file:  " + fileName);
            }
        } catch (Exception e) {
            System.out.println("File: " + fileName + " is not found!");
        }
        for (Map.Entry<String, String> entry : propertiesMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }


    }
}
