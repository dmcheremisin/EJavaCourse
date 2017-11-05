package lesson151020;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Dmitrii on 07.10.2017.
 */
public class ChatImpl implements Chat {

    public List<SocketHandler> clients = new LinkedList<>();
    BlockingQueue<String> messages = new LinkedBlockingQueue<>();

    public ChatImpl() {
        ChatServer.service.execute(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        String message = messages.take();
                        broadcast(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void received(SocketHandler exclude, String line) {
        messages.offer(exclude + " > " + line);
    }

    private void broadcast(String line) {
        System.out.println(" >> " + line);
        for (SocketHandler socketHandler : clients) {
            ChatServer.service.execute(new Runnable() {
                @Override
                public void run() {
                    socketHandler.send(line);
                }
            });
        }
    }

    @Override
    public void register(SocketHandler client) {
        clients.add(client);
    }
}
