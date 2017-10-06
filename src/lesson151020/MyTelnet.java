package lesson151020;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dmitr on 01.10.2017.
 */
public class MyTelnet {

    static ExecutorService service = Executors.newWorkStealingPool();

    public static void main(String[] args) {
        System.out.println("start typing...");
        try {
            try (Socket socket = new Socket("localhost", 10000)) {

                OutputStream outputStream = socket.getOutputStream();
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        handleOutputToServer(outputStream);
                    }
                });

                try (Scanner scanner = new Scanner(socket.getInputStream())) {
                    while (scanner.hasNext()) {
                        System.out.println(scanner.nextLine());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleOutputToServer(OutputStream outputStream) {
        PrintWriter pw = new PrintWriter(outputStream);
        try (Scanner keyboardScanner = new Scanner(System.in)){
            while(keyboardScanner.hasNextLine()) {
                String line = keyboardScanner.nextLine();
                pw.println(line);
                pw.flush();
            }
        }
    }
}
