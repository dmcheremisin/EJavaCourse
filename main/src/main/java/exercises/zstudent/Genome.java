package exercises.zstudent;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author dmch0916
 *         Date: 08.09.2017
 *         Time: 13:08
 */
public class Genome {
    // ACGT
    public static int GENOME_SIZE = 1_000_000;
    public static char[] letters = {'A', 'C', 'G', 'T'};

    char[] sequence;

    public void generateSequence() {
        Random rand = new Random();
        sequence = new char[GENOME_SIZE];
        for (int i = 0; i < sequence.length; i++) {
            if (i % 10000 == 0) {
                System.out.println(i);
            }
            sequence[i] = letters[rand.nextInt(letters.length)];
        }
    }


    public void searchDuplicatesSorting(char[] data, int M) {
        System.out.println("Start");
        Map<Integer, String> words = splitByWords(data, M);
        System.out.println("Sort ");
        List<Map.Entry<Integer, String>> entries = sortWords(words);
        System.out.println("Search ");
        findEqualWords(entries);
        System.out.println("Stop");
    }

    private Map<Integer, String> splitByWords(char[] data, int M) {
        Map<Integer, String> words = new HashMap<>();
        for (int i = 0; i < data.length - M + 1; i++) {
            String word = new String(data, i, M);
            words.put(i, word);
        }
        return words;
    }

    private List<Map.Entry<Integer, String>> sortWords(Map<Integer, String> words) {
        List<Map.Entry<Integer, String>> entries = new LinkedList<>(words.entrySet());
        Collections.sort(entries, Comparator.comparing(o -> ((String) o.getValue())));
        return entries;
    }

    private void findEqualWords(List<Map.Entry<Integer, String>> entries) {
        String last = "";
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            if(next.getValue().equals(last)) {
                System.out.println(next.getKey() + " = " + next.getValue());
            }
            last = next.getValue();
        }
    }

    public static void main(String[] args) {
        Genome genome = new Genome();
        genome.generateSequence();
        genome.searchDuplicatesSorting(genome.sequence, 10);
    }


}
