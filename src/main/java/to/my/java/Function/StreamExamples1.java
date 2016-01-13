package to.my.java.Function;

import java.util.stream.IntStream;

/**
 * Created by hreeman on 1/13/16.
 */
public class StreamExamples1 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " "));
        IntStream.iterate(1, i -> i + 1).forEach(i -> System.out.print(i + " "));
    }
}
