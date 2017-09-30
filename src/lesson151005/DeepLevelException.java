package lesson151005;

import java.util.Random;

/**
 * @author dmch0916
 *         Date: 08.09.2017
 *         Time: 19:02
 */
public class DeepLevelException {

    public static void main(String[] args) {
        boss();
    }

    private static void boss() {
        try {
            zam();
        } catch (Exception e) {
            System.out.println("reject");
        }
    }

    private static void zam() throws Exception {
        try {
            helper();
        } catch (Exception e) {
            if(e.getMessage().equals("haha")){
                System.out.println("stop joking");
                return;
            }
            throw e;
        }
    }

    private static void helper() throws Exception {
        intern();
    }

    private static void intern() throws Exception {
        tpm();
    }

    private static void tpm() throws Exception {
        Random random = new Random();
        int x = random.nextInt();
        throw x%2 == 0 ? new Exception("got a bug") : new Exception("haha");
    }

}
