package lesson150929;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author dmch0916
 *         Date: 04.09.2017
 *         Time: 19:31
 */
@Simple
public class Terminus {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("start typing");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            process(line);
        }
        System.out.println("finished");
        scanner.close();
    }
    private static void process(String line) {
//        switch(line) {
//            case "left" :  left(); break;
//            case "right" : right(); break;
//            case "sit" : sit(); break;
//            case "stand" : stand(); break;
//            default: System.out.println("unknown");
//        }
//        Class<?> clazz = Terminus.class;
//        clazz.getAnnotations();
//        for (Annotation annotation : clazz.getAnnotations()) {
//            System.out.println(annotation);
//        }
        for (Method method : Terminus.class.getMethods()) {
            if (method.isAnnotationPresent(Command.class)) {
                String anno = method.getAnnotation(Command.class).value();
                if (line.equalsIgnoreCase(anno)) {
                    try {
                        method.invoke(null, null);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Unknown command");
    }
    @Command("LEFT")
    public static void left() {
        System.out.println("moving left");
    }
    @Command("RIGHT")
    public static void right() {
        System.out.println("moving right");
    }
    @Command("SIT")
    public static void sit() {
        System.out.println("sat");
    }
    @Command("STAND")
    public static void stand() {
        System.out.println("stood");
    }
}
