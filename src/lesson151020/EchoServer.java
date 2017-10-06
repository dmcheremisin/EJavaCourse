package lesson151020;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dmitr on 06.10.2017.
 */
public class EchoServer {

    public static final int PORT = 10000;

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while(true){
                System.out.println("Listening incoming connections on port " + PORT);
                Socket socket = serverSocket.accept();
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        handle(socket);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle(Socket socket) {
        System.out.println("handling socket " + socket);
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            InputStream inputStream = socket.getInputStream();
            try (Scanner scanner = new Scanner(inputStream)) {
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                    pw.println("alright");
                    pw.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
