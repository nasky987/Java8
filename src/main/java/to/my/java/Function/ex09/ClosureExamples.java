package to.my.java.Function.ex09;

/**
 * Created by hreeman on 1/15/16.
 */
public class ClosureExamples {
    private int number = 999;

    @Override
    public String toString() {
        return new StringBuilder("ClosureExamples{")
                .append("number=")
                .append(number)
                .append('}')
                .toString()
                ;
    }

    public static void main(String[] args) {
        new ClosureExamples().test1();
        new ClosureExamples().test2();
    }

    private void test2() {
        final int number = 100;

        testClosure("Anonymous Class",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(this.toString());
                    }
                }
        );

        testClosure("Lambda Expression", () -> System.out.println(this.toString()));
    }

    private void test1() {
        final int number = 100;

        testClosure("Anonymous Class",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(ClosureExamples.this.number);
                    }
                }
        );

        testClosure("Lambda Expression", () -> System.out.println(this.number));
    }

    private static void testClosure(final String name, Runnable runnable) {
        System.out.println(name + ": ");
        runnable.run();
    }
}
