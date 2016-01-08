package to.my.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        final List<Integer> result2 = new ArrayList<>();
        for(Integer number : list) {
            if(number < 7 ) {
                result2.add(number);
            }
        }
    }

    private <T> List<T> filter(List<T> list, int biggerThan) {
        final List<T> result = new ArrayList<>();

        for(T value : list) {
            if(value > biggerThan) {
                result.add(value);
            }
        }

        return result;
    }
}
