package lesson151005;

/**
 * Created by dmitr on 30.09.2017.
 */
public class FinallyExamples {

    public static void main(String[] args) {

        System.out.println(getAge());

        try{
            System.out.println("вот те раз");
            throw new RuntimeException("stop");
        } finally {
            System.out.println("вот те два");
        }
    }

    private static int getAge() {
        try{
            return 20;
        } finally {
            return 30;
        }
    }
}
