package to.my.java;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Created by hreeman on 1/8/16.
 */
public class WhyJava8 {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final StringBuilder stringBuilder = new StringBuilder();
        final String separator = " : ";

        for (Integer number : numbers) {
            stringBuilder.append(number).append(separator);
        }

        final int stringLength = stringBuilder.length();
        if(stringLength > 0) {
            stringBuilder.delete(stringLength - separator.length(), stringLength);
        }

        System.out.println(stringBuilder.toString());

        final String result = numbers.stream()
                                     .map(String :: valueOf)
                                     .collect(joining(" : "));
        System.out.println(result);
    }
}
