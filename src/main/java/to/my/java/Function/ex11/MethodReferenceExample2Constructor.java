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
        final Function<Integer, Section> sectionFactory = number -> new Section(number);
        final Section section1WithFunction = sectionFactory.apply(1);
        System.out.println(section);
        System.out.println(section1WithFunction);
    }
}

@AllArgsConstructor
@Data
class Section {
    private int number;
}