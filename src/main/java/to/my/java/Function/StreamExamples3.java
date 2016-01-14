package to.my.java.Function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by hreeman on 1/14/16.
 */
public class StreamExamples3 {
    public static void main(String[] args) {
        System.out.println("collection(toList()): " +
            Stream.of(1, 3, 3, 5, 5)
                    .filter(i -> i > 2)
                    .map(i -> i * 2)
                    .map(i -> "#" + i)
                    .collect(toList())
        );

        System.out.println("collection(toSet()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(toSet())
        );

        System.out.println("collection(joining()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining())
        );

        System.out.println("collection(joining(\" , \")): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", "))
        );

        System.out.println("collection(joining(\" , \", \"[\", \"]\")): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", ", "[", "]"))
        );

                System.out.println("distinct().collection(joining(\" , \", \"[\", \"]\")): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(joining(", ", "[", "]"))
        );
    }
}
