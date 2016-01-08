package to.my.java;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hreeman on 1/8/16.
 */
public class WhyJava8 {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final StringBuilder stringBuilder = new StringBuilder();
        final String separator = " : - ";

        for (Integer number : numbers) {
            stringBuilder.append(number).append(separator);
        }

        if(stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length() - separator.length(), stringBuilder.length());
        }

        System.out.println(stringBuilder.toString());
    }
}
