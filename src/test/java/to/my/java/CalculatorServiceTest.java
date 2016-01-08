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

    @Test
    public void testCalculateSubtraction() throws Exception {
        CalculatorService calculatorService = new CalculatorService();

        final  int actual = calculatorService.calculate('-', 1, 1);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void testCalculateMultiplication() throws Exception {
        CalculatorService calculatorService = new CalculatorService();

        final  int actual = calculatorService.calculate('*', 1, 1);

        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void testCalculateDivision() throws Exception {
        CalculatorService calculatorService = new CalculatorService();

        final  int actual = calculatorService.calculate('/', 8, 0);

        assertThat(actual).isEqualTo(2);
    }
}