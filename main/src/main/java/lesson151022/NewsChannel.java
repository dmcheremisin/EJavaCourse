package lesson151022;

import lesson151008.Utils;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Dmitrii on 07.10.2017.
 */
public class NewsChannel {
    public static void main(String[] args) {
        NewsChannel newsChannel = new NewsChannel();
        newsChannel.register(new NewsMaker() {
            @Override
            public String getNews() {
                return "no news";
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start broadcasting...");
                while(true){
                    newsChannel.broadcastNews();
                    Utils.pause(3000);
                }
            }
        }).start();

        try (Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNextLine()){
                String command = scanner.nextLine();
                newsChannel.processCommand(command);
            }
        }
    }

    private void processCommand(String command) {
        try {
            Class<?> clazz = Class.forName(command);
            NewsMaker newsMaker = (NewsMaker) clazz.newInstance();
            register(newsMaker);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("Wrong news maker name. Try again...");
        }
    }

    private void broadcastNews() {
        for (NewsMaker newsMaker : newsMakers) {
            System.out.println(newsMaker.getNews());
        }
    }

    private List<NewsMaker> newsMakers = new CopyOnWriteArrayList<>();

    private void register(NewsMaker newsMaker) {
        newsMakers.add(newsMaker);
    }
}
