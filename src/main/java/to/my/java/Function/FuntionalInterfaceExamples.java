package to.my.java.Function;

import java.util.function.Function;

/**
 * Created by hreeman on 1/8/16.
 */
public class FuntionalInterfaceExamples {
    public static void main(String[] args) {
        Function<String, Integer> toInt = new Function<String, Integer>() {

            @Override
            public Integer apply(String value) {
                return Integer.parseInt(value);
            }
        };

        final Integer number = toInt.apply("100");
        System.out.println(number);
    }
}
