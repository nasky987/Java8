package to.my.java;

/**
 * Created by hreeman on 1/8/16.
 */
public class OopAnotherExample {
    public static void main(String[] args) {
        final CalculatorService calculatorService = new CalculatorService();
        final int addtionResult = calculatorService.calculate('+', 1, 1);
        System.out.println(addtionResult);

        final int substractionResult = calculatorService.calculate('-', 1, 1);
        System.out.println(substractionResult);
    }
}

class CalculatorService {
    public int calculate(char calculation, int num1, int num2) {
        if (calculation == '+') {
            return num1 + num2;
        } else if (calculation == '-') {
            return  num1 - num2;
        } else {
            throw new IllegalArgumentException("Unknown calculation: " + calculation);
        }
    }
}
