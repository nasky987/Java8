package to.my.java.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by hreeman on 1/8/16.
 */
public class FuntionalInterfaceExamples {
    public static void main(String[] args) {
        final Function<String, Integer> toInt = value -> Integer.parseInt(value);

        final Integer number = toInt.apply("100");
        System.out.println(number);

        final Function<Integer, Integer> identity = t -> t;

        System.out.println(identity.apply(999));

        final Consumer<String> print = value -> System.out.println(value);
        final Consumer<String> greetings = value -> System.out.println("Hello " + value);

        print.accept("Hello");
        greetings.accept("John");

        Predicate<Integer> isPositive = i -> i > 0;

        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(0));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);

        List<Integer> positiveNumbers = new ArrayList<>();
        for(Integer num : numbers) {
            if(isPositive.test(num)) {
                positiveNumbers.add(num);
            }
        }

        System.out.println("positive integers: " + positiveNumbers);

        Predicate<Integer> lessThan3 = i -> i < 3;

        List<Integer> numbersLessThan3 = new ArrayList<>();
        for(Integer num : numbers) {
            if(lessThan3.test(num)) {
                numbersLessThan3.add(num);
            }
        }

        System.out.println("lessThan integers: " + numbersLessThan3);

        System.out.println(filter(numbers, i -> i > 0));
        System.out.println(filter(numbers, isPositive));

        List<Integer> result = filter(numbers, lessThan3);
        System.out.println(result);

        final Supplier<String> helloSupplier = () -> "Hello ";
        System.out.println(helloSupplier.get() + "World!");

        printIfValidIndex(0, "John");
        printIfValidIndex(1, "John");
        printIfValidIndex(-1, "John");
    }

    private static void printIfValidIndex(int number, String value) {
        if(number >= 0) {
            System.out.println("The values is " + value + ".");
        }else {
            System.out.println("Invalid");
        }
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();

        for(T input : list) {
            if(filter.test(input)) {
                result.add(input);
            }
        }

        return result;
    }
}
