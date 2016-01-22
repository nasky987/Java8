package to.my.java.Function.ex11;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by hreeman on 1/22/16.
 */
public class MethodReferenceExample2Constructor {
    public static void main(String[] args) {
        final Section section = new Section(1);

        final Function<Integer, Section> sectionFactoryWithLambdaExpression = number -> new Section(number);
        final Section section1WithLambdaExpression = sectionFactoryWithLambdaExpression.apply(1);

        final Function<Integer, Section> sectionFactoryWithMethodReference = Section::new;
        final Section section1WithMethodReference = sectionFactoryWithMethodReference.apply(1);

        System.out.println(section);
        System.out.println(section1WithLambdaExpression);
        System.out.println(section1WithMethodReference);

        System.out.println("================================================");
        final Product product = new Product(1L, "A", new BigDecimal("100"));
        System.out.println(product);

        final ProductCreator productCreator = Product::new;
        System.out.println(productCreator.create(1L, "A", new BigDecimal("100")));
    }
}

@FunctionalInterface
interface ProductCreator {
    Product create(Long id, String name, BigDecimal price);
}

@AllArgsConstructor
@Data
class Section {
    private int number;
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}