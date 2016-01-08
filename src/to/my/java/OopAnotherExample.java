package to.my.java;

/**
 * Created by hreeman on 1/8/16.
 */
public class OopAnotherExample {
    public static void main(String[] args) {
        final CalculatorService calculatorService = new CalculatorService();
        final int result = calculatorService.calculate(1, 1);
        System.out.println(result);
    }
}

class CalculatorService {
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
