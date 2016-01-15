package to.my.java.Function.ex09;

/**
 * Created by hreeman on 1/15/16.
 */
public class ClosureExamples {
    public static void main(String[] args) {
        final int number = 100;

        System.out.println("Anonymous Class");

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        };
        runnable.run();

        System.out.println("Lambda");
        final Runnable runnable2 = () -> System.out.println(number);
        runnable2.run();
    }

    private static void testClosure(final String name, Runnable runnable) {
        System.out.println("Start " + name + ": ");
        runnable.run();
    }
}
