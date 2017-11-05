package lesson151001;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
            if (i % 1000 == 0) {
                System.out.println(i);
            }
            sequence[i] = letters[rand.nextInt(letters.length)];
        }
    }

    public void searchDuplicatesBruteForce(char[] data, int M) {
        for (int i = 0; i < data.length - M + 1; i++) {
            for (int j = i+1; j < data.length - M + 1; j++) {
                int k = i;
                int m = j;
                int n = 0;
                while(data[k++] == data[m++] && ++n < M) {
                }
                if (n == M) {
                    System.out.println("Match at " + i + " and " + j);

                }
            }
        }
    }

    public void searchDuplicatesSorting(char[] data, int M) {
        System.out.println("Start");
        List<String> words = new LinkedList<>();
        for (int i = 0; i < data.length - M + 1; i++) {
            String word = new String(data, i, M);
            words.add(word);
        }
        System.out.println("Sort");
        Collections.sort(words);
        String last = "";
        System.out.println("Search");
        Iterator<String> iterator = words.iterator();
        while(iterator.hasNext()) {
            String word = iterator.next();
            if(word.equals(last)) {
            }
            last = word;
        }
        System.out.println("Stop");
    }

    public static void main(String[] args) {
        Genome genome = new Genome();
        genome.searchDuplicatesBruteForce(new char[]{'A','A','C','T','A','A','C'}, 3);
        genome.generateSequence();
        //genome.searchDuplicatesBruteForce(genome.sequence, 10);
        genome.searchDuplicatesSorting(genome.sequence, 10);
    }


}
