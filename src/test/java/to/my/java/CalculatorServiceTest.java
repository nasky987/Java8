package to.my.java;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by hreeman on 1/8/16.
 */
public class CalculatorServiceTest {

    @Test
    public void testCalculateAddition() throws Exception {
        Calculation calculation = new Addition();

        final  int actual = calculation.calculate(1, 1);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void testCalculateSubtraction() throws Exception {
        Calculation calculation = new Subtraction();

        final  int actual = calculation.calculate(1, 1);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void testCalculateMultiplication() throws Exception {
        Calculation calculation = new Multiplication();

        final  int actual = calculation.calculate(1, 1);

        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void testCalculateDivision() throws Exception {
        Calculation calculation = new Divistion();

        final  int actual = calculation.calculate(8, 4);

        assertThat(actual).isEqualTo(2);
    }
}