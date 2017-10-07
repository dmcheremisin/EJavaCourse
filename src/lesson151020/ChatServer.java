package lesson151020;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dmitr on 07.10.2017.
 */
public class ChatServer implements Chat{

    private static ExecutorService service = Executors.newCachedThreadPool();
    private static final Chat chat = new ChatServer();

    public static void main(String[] args) {
        System.out.println("start");
        try(ServerSocket ss = new ServerSocket(10000)){
            while(true) {
                Socket socket = ss.accept();
                SocketHandler client = new SocketHandler(chat, socket);
                chat.register(client);
                service.execute(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<SocketHandler> clients = new LinkedList<>();
    private ChatServer(){}

    @Override
    public void received(SocketHandler exclude, String line) {
        System.out.println(exclude + " >> " + line);
        for (SocketHandler socketHandler : clients) {
            //if(socketHandler != exclude) {
                socketHandler.send(line);
            //}
        }
    }

    @Override
    public void register(SocketHandler client) {
        clients.add(client);
    }
}
