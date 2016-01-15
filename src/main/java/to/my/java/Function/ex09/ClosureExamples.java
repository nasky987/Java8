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
                .toString();
    }

    public static <T> String toString(T value) {
        return "The value is " + String.valueOf(value);
    }

    public static void main(String[] args) {
        new ClosureExamples().test1();
        System.out.println("=========================");

        new ClosureExamples().test2();
        System.out.println("=========================");

        new ClosureExamples().test3();
        System.out.println("=========================");

        new ClosureExamples().test4();
        System.out.println("=========================");
    }

    private void test4() {
        final int number = 100;

        testClosure("Anonymous Class",
                new Runnable() {
                    @Override
                    public void run() {
                        int number = 50;
                        System.out.println(number);
                    }
                }
        );

        testClosure("Lambda Expression", () -> {
//            int number = 50; //compile error cause duplication variable to final int number=100;
            System.out.println(number);
        });
    }

    private void test3() {
        final int number = 100;

        testClosure("Anonymous Class",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("toString(value): " + toString());
                    }
                }
        );

        testClosure("Lambda Expression", () -> System.out.println(toString("Test")));
    }

    private void test2() {
        final int number = 100;

        testClosure("Anonymous Class",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("this.toString(): " + this.toString());
                    }
                }
        );

        testClosure("Anonymous Class",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("ClosureExamples().this.toString(): " + ClosureExamples.this.toString());
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
