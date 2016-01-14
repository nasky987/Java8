package to.my.java.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
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
        Integer result = null;

        for(final Integer number : numbers) {
            if(number > 3 && number < 9) {
                final Integer newNumber = number * 2;
                if(newNumber > 10) {
                    result = newNumber;
                    break;
                }
            }
        }
        System.out.println("Imperative Result: " + result);

        System.out.println("Funtional Result: " +
            numbers.stream()
                    .filter(number -> {
                        System.out.println("number " + number + " is > 3? ");
                        return number > 3;
                    })
                    .filter(number -> {
                        System.out.println("number " + number + " is < 9? ");
                        return number < 9;
                    })
                    .map(number -> {
                        System.out.println("number " + number + " is * 2? ");
                        return number * 2;
                    })
                    .filter(number -> {
                        System.out.println("number " + number + " is > 10? ");
                        return number > 10;
                    })
                    .findFirst()
        );

        final List<Integer> greaterThan3 = filter(numbers, i -> {
            System.out.println("Costum Function i " + i + " is > 3? ");
            return i > 3;
        });
        final List<Integer> lessThan9 = filter(greaterThan3, i -> {
            System.out.println("Costum Function i " + i + " is < 9? ");
            return i < 9;
        });
        final List<Integer> doubled = map(lessThan9, i -> {
            System.out.println("Costum Function i " + i + " is * 2 ? ");
            return i * 2;
        });
        final List<Integer> greaterThan10 = filter(doubled, i -> {
            System.out.println("Costum Function i " + i + " is > 10? ");
            return i > 10;
        });
        System.out.println(greaterThan10.get(0));
    }

    private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        final List<T> result = new ArrayList<>();
        for(final T t : list) {
            if(predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for(final T t : list) {
            result.add(mapper.apply(t));
        }

        return result;
    }
}
