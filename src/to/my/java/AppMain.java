package to.my.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jhon on 2016-01-07.
 */
public class AppMain {
    public static void main(String[] args) {
        try (final FileReader fileReader = new FileReader(new File("D:\\Developer Data/InteliJ_Workspace/Java8/src/to/my/java/temp/test1.txt"));
            final BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            final List<String> uniqueWords = new ArrayList<>();
            String line = bufferedReader.readLine();
            while(line != null) {
                final String[] words = line.split("[\\s]+");
                for(String word : words) {
                    if(!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }
                }
                line = bufferedReader.readLine();
            }

            Collections.sort(uniqueWords);
            System.out.println(uniqueWords);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
