package to.my.java.Function.ex09;

/**
 * Created by hreeman on 1/15/16.
 */
public class ClosureExamples {
    public static void main(String[] args) {
        final int number = 100;

        testClosure("Anonymous Class",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(number);
                    }
                }
        );

        testClosure("Lambda Expression", () -> System.out.println(number));
    }

    private static void testClosure(final String name, Runnable runnable) {
        System.out.println(name + ": ");
        runnable.run();
    }
}
