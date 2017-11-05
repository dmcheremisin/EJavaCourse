package exercises.module1;

/**
 * Created by dmitr on 20.08.2017.
 */
public class FunctionTg {
    static int a = 0, b = 100, step = 3;

    public static void main(String[] args) {
        int steps = b/step;
        for(int i = a; i < b; i+= step) {
            System.out.print(i + "  ||  ");
            Double result = Math.tan(2 * i) - 3;
            System.out.println(result);
        }
    }

}
