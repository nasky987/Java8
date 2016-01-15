package to.my.java.Function;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by hreeman on 1/15/16.
 */
public class StreamExamples5ParrelPerformancePractical {
    private static final String[] priceStrings = {"1.0", "100.99", "35.75", "21.30", "88.00"};
    private static final Random random = new Random(123);

    private static final List<Product2> products;

    static {
        final int length = 8_000_000;
        final Product2[] list = new Product2[length];

        for(int i = 1; i <= length; i++) {
            list[i-1] = (new Product2((long) i, "Product" + i, new BigDecimal(priceStrings[random.nextInt(5)])));
        }

        products = Collections.unmodifiableList(Arrays.asList(list));
    }

    private static BigDecimal imperativeSum(final List<Product2> products, final Predicate<Product2> predicate) {
        BigDecimal sum = BigDecimal.ZERO;

        for(final Product2 product : products) {
            if(predicate.test(product)) {
                sum = sum.add(product.getPrice());
            }
        }

        return sum;
    }

    private static BigDecimal streamSum(final Stream<Product2> stream, final Predicate<Product2> predicate) {
        return stream.filter(predicate)
                    .map(Product2::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static void imperativeTest(BigDecimal targetPrice) {
        System.out.println("==================================");
        System.out.println("\nImperative Sum\n-------------------------------------");

        final long start = System.currentTimeMillis();
        System.out.println("Sum : " + imperativeSum(products, product -> product.getPrice().compareTo(targetPrice) >= 0));
        System.out.println("It took " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("==================================");
    }

    private static void streamTest(BigDecimal targetPrice) {
        System.out.println("==================================");
        System.out.println("\nStream Sum\n-------------------------------------");

        final long start = System.currentTimeMillis();
        System.out.println("Sum : " + streamSum(products.stream(), product -> product.getPrice().compareTo(targetPrice) >= 0));
        System.out.println("It took " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("==================================");
    }

    private static void parallelStreamTest(BigDecimal targetPrice) {
        System.out.println("==================================");
        System.out.println("\nParallelStream Sum\n-------------------------------------");

        final long start = System.currentTimeMillis();
        System.out.println("Sum : " + streamSum(products.parallelStream(), product -> product.getPrice().compareTo(targetPrice) >= 0));
        System.out.println("It took " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("==================================");
    }

    public static void main(String[] args) {
        final BigDecimal targetPrice = new BigDecimal("40");

        imperativeTest(targetPrice);
        streamTest(targetPrice);
        parallelStreamTest(targetPrice);
    }
}

@AllArgsConstructor
@Data
class Product2 {
    private Long id;
    private String name;
    private BigDecimal price;
}