package lesson151005;

/**
 * @author dmch0916
 *         Date: 08.09.2017
 *         Time: 18:44
 */
public class UseStack {

    public static void main(String[] args) {
        System.out.println("Start");
        Stack<String> stack = new Stack<>(2);
        try {
            String pop = stack.pop();
            System.out.println(pop);
        } catch (StackUnderflowException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        try {
            stack.push("One");
            stack.push("Two");
            stack.push("Three");
        } catch (StackOveflowException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("Finish");
    }

}
