package to.my.java;

/**
 * Created by hreeman on 1/8/16.
 */
public class OopAnotherExample {
    public static void main(String[] args) {
        final CalculatorService calculatorService = new CalculatorService(new Addition(), new Subtraction());
        final int additionResult = calculatorService.calculate(1, 1);
        System.out.println(additionResult);

        final CalculatorService calculatorService2 = new CalculatorService(new Subtraction(), new Multiplication());
        final int subtractionResult = calculatorService2.calculate(1, 1);
        System.out.println(subtractionResult);

        final CalculatorService calculatorService3 = new CalculatorService(new Multiplication(), new Divistion());
        final int multiplicationResult = calculatorService3.calculate(1, 1);
        System.out.println(multiplicationResult);

        final CalculatorService calculatorService4 = new CalculatorService(new Divistion(), new Addition());
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
    private final Calculation calculation2;

    public CalculatorService(final Calculation calculation, final Calculation calculation2) {
        this.calculation = calculation;
        this.calculation2 = calculation2;
    }

    public int calculate(int num1, int num2) {
        if(num1 > 10 && num2 < num1) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1:" + num1 + ", num2: " + num2);
        }
    }

    public int compute(int num1, int num2) {
        if(num1 > 10 && num2 < num1) {
            return calculation2.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1:" + num1 + ", num2: " + num2);
        }
    }
}
