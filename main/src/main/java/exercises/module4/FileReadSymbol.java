package exercises.module4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static exercises.module4.FileReadByte.sortWordsAndCount;

/**
 * Created by Dmitrii on 06.11.2017.
 */
public class FileReadSymbol {
    private static Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
    private static final String FILE =
            "C:\\Workspace\\EpamJava\\main\\src\\main\\java\\exercises\\module4\\FileReadSymbol.java";
    private static final String NEW_FILE = "C:\\Workspace\\EpamJava\\out\\words.txt";


    public static void main(String[] args) {
        List<String> words = getWords();
        Map<String, Integer> wordsAndCount = sortWordsAndCount(words);
        writeFile(wordsAndCount);
    }

    private static void writeFile(Map<String, Integer> wordsAndCount) {
        try (FileWriter fr = new FileWriter(NEW_FILE)) {
            for (Map.Entry<String, Integer> entry : wordsAndCount.entrySet()) {
                fr.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getWords() {
        List<String> words = new ArrayList<>();
        try (FileReader fr = new FileReader(FILE)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            Matcher matcher;
            while((line = br.readLine()) != null){
                matcher = wordPattern.matcher(line);
                while(matcher.find()) {
                    words.add(matcher.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

}
