package to.my.java.Function.ex11;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

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

        System.out.println();
        System.out.println(
            Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                    .stream()
                    .sorted()
                    .collect(toList())
        );

        System.out.println();
        System.out.println("==============================");
        System.out.println("Lambda Expression");
        System.out.println("==============================");
        System.out.println(
            Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                    .stream()
                    .sorted((bd1, bd2) -> bd1.compareTo(bd2))
                    .collect(toList())
        );

        System.out.println("==============================");
        System.out.println("Custom Method Reference with Class Method");
        System.out.println("==============================");
        System.out.println(
            Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                    .stream()
                    .sorted(BigDecimalUtil::compare)
                    .collect(toList())
        );

        System.out.println("==============================");
        System.out.println("Custom Method Reference with Any Object Instance Method");
        System.out.println("==============================");
        System.out.println(
            Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                    .stream()
                    .sorted(BigDecimal::compareTo)
                    .collect(toList())
        );

        System.out.println("==============================");
        System.out.println(
            Arrays.asList("a", "b", "c" ,"d")
                .stream()
                .anyMatch(x -> x.equals("c"))
        );

        System.out.println("==============================");
        System.out.println(
                Arrays.asList("a", "b", "c" ,"d")
                        .stream()
                        .anyMatch("c"::equals)
//                        .anyMatch(String::equals) //wrong Case
        );

        System.out.println("==============================");
        System.out.println("Custom Method Reference with Special Object Instance Method");
        System.out.println("==============================");

        final String targetString = "c";
        System.out.println(
                Arrays.asList("a", "b", "c" ,"d")
                        .stream()
                        .anyMatch(targetString::equals)
//                        .anyMatch(String::equals) //wrong Case
        );

        System.out.println();
        methodReference03();
    }

    private static void methodReference03() {
        System.out.println(testFirstClassFunction(3, i -> String.valueOf(i * 2)));
        System.out.println(testFirstClassFunction(3, MethodReferenceExamples::doubleThenToString));

        System.out.println("=======================================================");
        final Function<Integer, String> fl1 = getDoubleThenToStringUsingLambdaExpression();
        final String resultFromFl = fl1.apply(3);
        System.out.println(resultFromFl);

        final Function<Integer, String> fmr = getDoubleThenToStringUsingMethodReference();
        final String resultFromFrm = fmr.apply(3);
        System.out.println(resultFromFrm);

        System.out.println("========================================================");
        final List<Function<Integer, String>> fsL = Arrays.asList(i -> String.valueOf(i * 2));
        for(final Function<Integer, String> f : fsL) {
            final String result = f.apply(3);
            System.out.println(result);
        }

        final List<Function<Integer, String>> fsMr = Arrays.asList(MethodReferenceExamples::doubleThenToString);
        for(final Function<Integer, String> f : fsMr) {
            final String result = f.apply(3);
            System.out.println(result);
        }

        System.out.println("========================================================");
        final Function<Integer, String> fl2 = i -> String.valueOf(i * 2);
        final String resultFl2 = fl2.apply(5);
        System.out.println(resultFl2);

        final Function<Integer, String> fmr2 = MethodReferenceExamples::doubleThenToString;
        final String resultFmr2 = fmr2.apply(5);
        System.out.println(resultFmr2);
    }

    private static String testFirstClassFunction(int n, Function<Integer, String> f){
        return "The result is " + f.apply(n);
    }

    private static String doubleThenToString(int i) {
        return String.valueOf(i * 2);
    }

    private static Function<Integer, String> getDoubleThenToStringUsingLambdaExpression() {
        return i -> String.valueOf(i * 2);
    }

    private static Function<Integer,String> getDoubleThenToStringUsingMethodReference() {
        return MethodReferenceExamples::doubleThenToString;
    }
}

class BigDecimalUtil {
    public static int compare(BigDecimal bd1, BigDecimal bd2) {
        return bd1.compareTo(bd2);
    }
}