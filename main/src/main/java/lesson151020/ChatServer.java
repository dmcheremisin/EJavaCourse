package lesson151020;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Dmitrii on 07.10.2017.
 */
public class ChatServer {

    private static final Chat chat = new ChatImpl();
    static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        System.out.println("start");
        try(ServerSocket ss = new ServerSocket(10000)){
            while(true) {
                System.out.println("new socket");
                Socket socket = ss.accept();
                SocketHandler client = new SocketHandler(chat, socket);
                chat.register(client);
                service.execute(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
