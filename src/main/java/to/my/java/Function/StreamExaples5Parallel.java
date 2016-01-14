package to.my.java.Function;

import java.util.stream.IntStream;

/**
 * Created by hreeman on 1/14/16.
 */
public class StreamExaples5Parallel {
    public static void main(String[] args) {
        final int[] sum = { 0 };
        IntStream.range(0, 100)
                .forEach(i -> sum[0] += i);

        System.out.println("sum: " + sum[0]);
    }
}
