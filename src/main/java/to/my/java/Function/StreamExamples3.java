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

        System.out.println("distinct().collection(toList()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(toList())
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5)
                    .filter(i -> i == 3)
                    .findFirst()
        );

        final Integer integer3 = 3;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5)
                    .filter(i -> i == integer3)
                    .findFirst()
        );

        final Integer integer127 = 127;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 127)
                    .filter(i -> i == integer127)
                    .findFirst()
        );

        final Integer integer128 = 128;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                    .filter(i -> i == integer128)
                    .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                    .filter(i -> i.equals(integer128))
                    .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5)
                    .filter(i -> i > 3)
                    .count()
        );
    }
}
