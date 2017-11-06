package exercises.module4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Dmitrii on 06.11.2017.
 */
public class FileReadByte {

    private static Pattern wordPattern = Pattern.compile("[a-zA-Z]");
    private static final String FILE =
            "C:\\Workspace\\EpamJava\\main\\src\\main\\java\\exercises\\module4\\FileReadByte.java";
    private static final String NEW_FILE = "C:\\Workspace\\EpamJava\\out\\words.txt";

    public static void main(String[] args) {
        List<String> words = readWordsByByte();
        Map<String, Integer> sortedMap = sortWordsAndCount(words);
        writeWords(sortedMap);

    }

    private static List<String> readWordsByByte() {
        List<String> words = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(FILE)) {
            int info;
            Matcher matcher;
            StringBuilder sb = new StringBuilder();
            boolean isNotWord = true;
            while ((info = fileInputStream.read()) != -1) {
                char inputChar = (char) info;
                matcher = wordPattern.matcher(inputChar + "");
                if (matcher.matches()) {
                    sb.append(inputChar);
                    isNotWord = false;
                } else if (!isNotWord) {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                    isNotWord = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public static Map<String, Integer> sortWordsAndCount(List<String> words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        words.forEach(word -> {
                    if (wordsMap.containsKey(word)) {
                        Integer quantity = wordsMap.get(word);
                        wordsMap.put(word, ++quantity);
                    } else {
                        wordsMap.put(word, 1);
                    }
                }
        );
        Map<String, Integer> sortedMap = wordsMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new)
                );
        sortedMap.keySet().forEach(key -> System.out.println(key + " : " + wordsMap.get(key)));
        return sortedMap;
    }

    private static void writeWords(Map<String, Integer> sortedMap) {
        try (FileOutputStream out = new FileOutputStream(NEW_FILE)) {
            for (String key : sortedMap.keySet()) {
                out.write((key + ":" + sortedMap.get(key) + "\n").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
