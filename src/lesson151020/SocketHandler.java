package lesson151020;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by dmitr on 07.10.2017.
 */
public class SocketHandler implements Runnable {
    private final PrintWriter printWriter;
    private Chat chat;
    private Socket socket;

    public SocketHandler(Chat chat, Socket socket) throws IOException {
        this.chat = chat;
        this.socket = socket;
        printWriter = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            try (Scanner scanner = new Scanner(socket.getInputStream())){
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    chat.received(this, line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String line) {
        printWriter.println(line);
        printWriter.flush();
    }
}
