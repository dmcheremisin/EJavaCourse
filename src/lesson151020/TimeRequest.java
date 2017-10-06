package lesson151020;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by dmitr on 06.10.2017.
 */
public class TimeRequest {
    public static void main(String[] args) {
        try(Socket socket = new Socket("time-a.nist.gov", 13)){
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
