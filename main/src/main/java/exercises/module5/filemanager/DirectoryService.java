package exercises.module5.filemanager;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Dmitrii on 16.11.2017.
 */
public class DirectoryService {
    private static final String UP = "..";

    public static void listDir(File path, int level) throws FilesNotFoundException {
        File[] files = path.getAbsoluteFile().listFiles();
        if (files == null) {
            throw new FilesNotFoundException("Can't list empty directory!");
        }
        StringBuilder nav = new StringBuilder();
        for (int i = 0; i < level; i++) {
            nav.append(" ");
        }
        nav.append("|__");
        for (File file : files) {
            if(file != null) {
                if (file.isFile()) {
                    System.out.println(nav + "File     : " + file.getName());
                }
                if (file.isDirectory()) {
                    System.out.println(nav);
                    System.out.println(nav + "Directory: " + file.getName());
                    //listDir(file, ++level);
                }
            }
        }
    }

    public static File openDir(Scanner sc, File path) throws DirNotFoundException {
        System.out.print("Type directory name: ");
        String dir = sc.nextLine();
        try {
            String absolutePath = path.getAbsolutePath();
            File file;
            if (UP.equals(dir)) {
                String upDir = absolutePath.substring(0, absolutePath.lastIndexOf("\\"));
                file = new File(upDir);
            } else {
                file = new File(absolutePath + "\\" + dir);
            }
            System.out.println("Opened: " + file.getAbsolutePath());
            path = file;
        } catch (Exception e) {
            throw new DirNotFoundException("Directory with name: " + dir + " is not found!");
        }
        return path;
    }
}
