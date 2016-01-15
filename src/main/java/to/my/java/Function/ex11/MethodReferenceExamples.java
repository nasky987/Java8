package to.my.java.Function.ex11;

import java.util.Arrays;

/**
 * Created by hreeman on 1/15/16.
 */
public class MethodReferenceExamples {
    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5)
                .forEach(i -> System.out.println(i));

        System.out.println("=========================================");
        System.out.println("Method Reference");
        System.out.println("=========================================");
        Arrays.asList(1, 2, 3, 4, 5)
                .forEach(System.out::println);
    }
}
