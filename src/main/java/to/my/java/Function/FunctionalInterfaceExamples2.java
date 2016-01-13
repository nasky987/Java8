package to.my.java.Function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
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

        final List<Product> expensiveProducts =
                filter(products, product -> product.getPrice().compareTo(new BigDecimal("50")) >=0 );
        final List<DiscountedProduct> discountedProducts =
                map(expensiveProducts, product ->
                        new DiscountedProduct(product.getId(), product.getName(), product.getPrice()
                        .multiply(new BigDecimal("0.5"))));

        System.out.println(" expensive products: " + expensiveProducts);
        System.out.println("discounted products: " + discountedProducts);

        final Predicate<DiscountedProduct> lessThanOrEqualTo30 = product -> product.getPrice().compareTo(new BigDecimal("30")) <= 0);
        System.out.println("discounted products(<= $30): " + filter(discountedProducts, lessThanOrEqualTo30);
        System.out.println("           products(<= $30): " + filter(products, lessThanOrEqualTo30);
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

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        final List<R> result = new ArrayList<>();
        for(final T t : list) {
            result.add(function.apply(t));
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

@ToString(callSuper = true)
class DiscountedProduct extends Product {
    public DiscountedProduct(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }
}