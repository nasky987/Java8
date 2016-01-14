package to.my.java.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by hreeman on 1/14/16.
 */
public class StreamExamples2 {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final List<Integer> result = new ArrayList<>();
        for(final Integer number : numbers) {
            if(number > 3 && number < 9) {
                final Integer newNumber = number * 2;
                result.add(newNumber);
            }
        }
        System.out.println("Imperative Result: " + result);
    }
}
