package to.my.java.Function;

import java.util.function.Consumer;
import java.util.function.Function;

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

        final Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        };

        print.accept("Hello");

    }
}
