package exercises.module5.filemanager;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Dmitrii on 16.11.2017.
 */
public class FileService {

    public static final String EXIT_CONST = "exit123";

    public static void openFile(Scanner sc, File path) {
        System.out.print("Type file name: ");
        String fname = sc.nextLine();
        String fileDest = getFilePath(path, fname);
        try (FileReader fr = new FileReader(fileDest)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Can't find this file = " + fname);
        }
    }

    private static String getFilePath(File path, String fname) {
        return path.getAbsolutePath() + "\\" + fname;
    }

    public static void createFile(Scanner sc, File path) {
        System.out.print("Type file name to create: ");
        String fname = sc.nextLine();
        String filePath = getFilePath(path, fname);
        File f = new File(filePath);
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Can't create file: " + filePath);
            }
        }
    }

    public static void changeFile(Scanner sc, File path) {
        System.out.print("Type file name to change: ");
        String fname = sc.nextLine();
        String filePath = getFilePath(path, fname);
        try(FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            System.out.println("Type your text here");
            System.out.println("Type " + EXIT_CONST + " if you want to finish writing");
            while(true) {
                String next = sc.nextLine();
                if (next.equals(EXIT_CONST)) {
                    break;
                }
                out.println(next);
            }
        } catch (IOException e) {
            System.out.println("Can't write to the file: " + fname);
        }
    }

    public static void deleteFile(Scanner sc, File path) {
        System.out.print("Type file name to change: ");
        String fname = sc.nextLine();
        String filePath = getFilePath(path, fname);
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("File: " + fname + " is deleted!");
        } else {
            System.out.println("Can't delete file: " + fname);
        }
    }
}
