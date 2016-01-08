package to.my.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        List<Integer> result3 = filter(list, n -> n > 2);
        System.out.println(result3);

        List<Integer> result4 = filter(list, n -> n < 7);
        System.out.println(result4);
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
