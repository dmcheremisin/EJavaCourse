package lesson151020;

/**
 * Created by dmitr on 07.10.2017.
 */
public interface Chat {
    void received(SocketHandler socketHandler, String line);

    void register(SocketHandler client);
}
