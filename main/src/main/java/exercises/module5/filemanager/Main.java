package exercises.module5.filemanager;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Dmitrii on 14.11.2017.
 */
public class Main {

    public static final String LIST_DIR = "ls";
    public static final String OPEN_DIR = "cd";
    public static final String READ_FILE = "read";
    public static final String CREATE_FILE = "create";
    public static final String DELETE_FILE = "delete";
    public static final String CHANGE_FILE = "change";
    public static final String EXIT = "exit";
    public static File path = new File("");

    public static void main(String[] args) {
        printLegend();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Type your command: ");
            String input = sc.nextLine();
            if (EXIT.equals(input)) {
                break;
            }
            switch (input) {
                case LIST_DIR:
                    try {
                        DirectoryService.listDir(path, 0);
                    } catch (FilesNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case OPEN_DIR:
                    path = DirectoryService.openDir(sc, path);
                    break;
                case READ_FILE:
                    FileService.openFile(sc, path);
                    break;
                case CREATE_FILE:
                    FileService.createFile(sc, path);
                    break;
                case DELETE_FILE:
                    FileService.deleteFile(sc, path);
                    break;
                case CHANGE_FILE:
                    FileService.changeFile(sc, path);
                    break;
//            }
            }
        }
    }

    private static void printLegend() {
        System.out.println("Current directory is:");
        System.out.println(path.getAbsolutePath());
        System.out.println("List directory: " + LIST_DIR);
        System.out.println("Open directory: " + OPEN_DIR);
        System.out.println("Open file: " + READ_FILE);
        System.out.println("Create file: " + CREATE_FILE);
        System.out.println("Delete file: " + DELETE_FILE);
        System.out.println("Change file: " + CHANGE_FILE);
        System.out.println("Exit: " + EXIT);
    }
}
