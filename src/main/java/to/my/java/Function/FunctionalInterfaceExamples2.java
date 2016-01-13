package to.my.java.Function;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by hreeman on 1/13/16.
 */
public class FunctionalInterfaceExamples2 {
    public static void main(String[] args) {
        final List<Product> products = Arrays.asList(
                new Product(1L, "A", new BigDecimal("10.00")),
                new Product(2L, "B", new BigDecimal("55.00")),
                new Product(3L, "C", new BigDecimal("17.45")),
                new Product(4L, "D", new BigDecimal("20.00")),
                new Product(5L, "E", new BigDecimal("110.99"))
        );
        System.out.println(products);

        final BigDecimal twenty = new BigDecimal("20");
        final List<Product> result = filter(products, product -> product.getPrice().compareTo(twenty) >= 0);
        System.out.println("products >= $20:" + result);
        System.out.println("products <= $10:" +
                filter(products, product -> product.getPrice().compareTo(new BigDecimal("10")) <= 0));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();
        for(final T t : list) {
            if(predicate.test(t)) {
                result.add(t);
            }
        }

        return result;
    }
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}