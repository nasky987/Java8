package to.my.java;

/**
 * Created by hreeman on 1/8/16.
 */
public class OopAnotherExample {
    public static void main(String[] args) {
        final CalculatorService calculatorService = new CalculatorService(new Addition());
        final int additionResult = calculatorService.calculate(1, 1);
        System.out.println(additionResult);

        final CalculatorService calculatorService2 = new CalculatorService(new Subtraction());
        final int subtractionResult = calculatorService2.calculate(1, 1);
        System.out.println(subtractionResult);

        final CalculatorService calculatorService3 = new CalculatorService(new Multiplication());
        final int multiplicationResult = calculatorService3.calculate(1, 1);
        System.out.println(multiplicationResult);

        final CalculatorService calculatorService4 = new CalculatorService(new Divistion());
        final int divisionResult = calculatorService4.calculate(8, 4);
        System.out.println(divisionResult);
    }
}

interface Calculation {
    int calculate(int num1, int num2);
}

class Addition implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class Subtraction implements  Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}

class Multiplication implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}

class Divistion implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 / num2;
    }
}
class CalculatorService {
    private final Calculation calculation;

    public CalculatorService(Calculation calculation) {
        this.calculation = calculation;
    }

    public int calculate(int num1, int num2) {
        return calculation.calculate(num1, num2);
    }
}
