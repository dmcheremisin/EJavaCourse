package exercises.module3;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by Dmitrii on 05.11.2017.
 */
public class Int8tion {

    public static void main(String[] args) {
        System.out.println("1 - Ru, 2 - En");
        Locale locale = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            System.out.println(input);
            if ("1".equals(input)) {
                locale = new Locale("ru");
                break;
            } else if ("2".equals(input)) {
                locale = new Locale("en");
                break;
            }
        }

        ResourceBundle questions = ResourceBundle.getBundle("questions", locale);
        String exit = questions.getString("exit");
        ResourceBundle answers = ResourceBundle.getBundle("answers", locale);
        System.out.println(questions.getString("default"));
        while (true){
            String nextInput = scanner.nextLine();
            if(exit.equals(nextInput)){
                break;
            }else if (questions.containsKey(nextInput)) {
                System.out.println(questions.getString(nextInput));
                System.out.println(answers.getString(nextInput));
            }
            System.out.println(questions.getString("default"));
        }

    }
}
