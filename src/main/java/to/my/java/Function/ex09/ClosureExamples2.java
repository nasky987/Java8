package to.my.java.Function.ex09;

/**
 * Created by hreeman on 1/15/16.
 */
public class ClosureExamples2 {
    private int number = 999;

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int number = 100;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        };
        runnable.run();

        Runnable runnable2 = () -> System.out.println(number);
        runnable2.run();
    }
}
