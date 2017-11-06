package exercises.module4;

import java.io.*;

/**
 * Created by Dmitrii on 06.11.2017.
 */
public class FileChangeCharset {

    private static final String FILE_UTF8 = "C:\\Workspace\\EpamJava\\out\\words.txt";
    private static final String FILE_UTF16 = "C:\\Workspace\\EpamJava\\out\\words_new.txt";

    public static void main(String[] args) {
        try (InputStreamReader ir = new InputStreamReader(new FileInputStream(FILE_UTF8), "UTF-8");
             OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(FILE_UTF16), "UTF-16")) {
            BufferedReader bufferedReader = new BufferedReader(ir);
            BufferedWriter bufferedWriter = new BufferedWriter(ow);
            String line;
            while((line = bufferedReader.readLine()) != null ){
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
            }
            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
