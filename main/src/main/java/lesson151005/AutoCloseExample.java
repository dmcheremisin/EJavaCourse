package lesson151005;

import java.util.Scanner;

/**
 * Created by dmitr on 30.09.2017.
 */
public class AutoCloseExample {

    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }

    }

}
