package to.my.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * Created by Jhon on 2016-01-08.
 */
public class LambdaExample {
    public  static  void main(String[] args) {
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8 , 9, 10);

        final List<Integer> result1 = new ArrayList<>();
        for(Integer number : list) {
            if(number > 2) {
                result1.add(number);
            }
        }
        System.out.println(result1);

        final List<Integer> result2 = new ArrayList<>();
        for(Integer number : list) {
            if(number < 7 ) {
                result2.add(number);
            }
        }
        System.out.println(result2);

        final Predicate<Integer> greaterThan2 = n -> n > 2;
        List<Integer> result3 = filter(list, greaterThan2);
        System.out.println(result3);

        final Predicate<Integer> lessThan7 = n -> n < 7;
        List<Integer> result4 = filter(list, lessThan7);
        System.out.println(result4);

        List<Integer> result5 = filter(result3, n -> n < 7);
        System.out.println(result5);

        List<Integer> result6 = filter(list, greaterThan2.and(lessThan7));
        System.out.println(result6);

        int factor = 10;
        Comparator<Integer> comparator = (o1, o2) -> o1 > factor ? o1 : o1.compareTo(o2);

        long start = System.currentTimeMillis();
        int total = Arrays.asList(1, 2, 3)
                .parallelStream()
                .peek(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .reduce(0, (i1, i2) -> i1 + i2);
        System.out.println("It took " + (System.currentTimeMillis() - start));
        System.out.println(total);
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();

        for(T value : list) {
            if(predicate.test(value)) {
                result.add(value);
            }
        }

        return result;
    }
}
