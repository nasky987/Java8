package to.my.java.Function;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by hreeman on 1/14/16.
 */
public class StreamExaples4 {
    public static void main(String[] args) {
        final List<Product> products =
                Arrays.asList(
                        new Product(1L, "A", new BigDecimal("100.50")),
                        new Product(2L, "B", new BigDecimal("23.00")),
                        new Product(3L, "C", new BigDecimal("31.45")),
                        new Product(4L, "D", new BigDecimal("80.20")),
                        new Product(5L, "E", new BigDecimal("7.50"))
                );

        System.out.println("Products.getPrice() >= 30 " +
            products.stream()
                    .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                    .collect(toList())
        );

        System.out.println("Products.getPrice() >= 30(with joining): \n" +
            products.stream()
                    .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                    .map(product -> product.toString())
                    .collect(joining("\n"))
        );

        System.out.println("====================================================");
        System.out.println("IntStream.sum: " +
            IntStream.of(1, 2, 3, 4, 5)
                .sum()
        );

        System.out.println("Total Price: " +
            products.stream()
                    .map(product -> product.getPrice())
                    .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        );
    }
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

@AllArgsConstructor
@Data
class OrderedItem {
    private Long id;
    private Product product;
    private int quantity;
}

@AllArgsConstructor
@Data
class Order {
    private Long id;
    private List<OrderedItem> items;
}
