package to.my.java;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by hreeman on 1/8/16.
 */
public class CalculatorServiceTest {

    @Test
    public void testCalculateAddition() throws Exception {
        CalculatorService calculatorService = new CalculatorService();

        final  int actual = calculatorService.calculate('+', 1, 1);

        assertThat(actual).isEqualTo(2);
    }
}