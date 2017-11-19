package exercises.module3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitrii on 06.11.2017.
 */
public class ArticleMatcher {

    private static Pattern picPattern = Pattern.compile("(Рис. (\\d))");
    private static final String FILE = "article.html";

    public static void main(String[] args) {
        ArticleMatcher articleMatcher = new ArticleMatcher();
        ClassLoader classLoader = articleMatcher.getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE).getFile());
        String s;
        List<String> lines = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), "windows-1251"))) {
            while((s = in.readLine()) != null){
                lines.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher matcher;
        Integer maxPic = 1;
        int counter = 0;
        List<String> divs = new ArrayList<>();
        for (String line : lines) {
            matcher = picPattern.matcher(line);
            if(matcher.find()) {
                divs.add(line);
//                String pic = matcher.group(0);
//                System.out.println(pic);
                String num = matcher.group(2);
                Integer picNum = Integer.parseInt(num);
                if(counter == 0){
                    maxPic = picNum;
                    counter++;
                } else {
                    System.out.println(maxPic + ",  " + picNum);
                    if(maxPic > picNum){
                        System.out.println("Порядок нарушен, наибольший номер : " + maxPic + ", текущий " + picNum);
                    }else {
                        maxPic = picNum;
                    }
                }
//                System.out.println(line);
            }
        }

        for (String div : divs) {
            System.out.println(div);
        }
    }
}
