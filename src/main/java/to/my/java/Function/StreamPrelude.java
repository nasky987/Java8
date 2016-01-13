package to.my.java.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by hreeman on 1/13/16.
 */
public class StreamPrelude {
    public static void main(String[] args) {
        final int abs1 = Math.abs(-1);
        final int abs2 = Math.abs(1);

        System.out.println("abs1: " + abs1);
        System.out.println("abs2: " + abs2);
        System.out.println("abs1 == abs2 is " + (abs1 == abs2));

        final int minInt = Integer.MIN_VALUE;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println("minInt: " + minInt);
    }
}
