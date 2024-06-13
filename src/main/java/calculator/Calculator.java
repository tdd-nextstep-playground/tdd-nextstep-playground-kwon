package calculator;

import java.util.List;

public class Calculator {
    private final List<Integer> numbers;
    private final List<String> operands;

    public Calculator(String expression) {
        NumberAndOperationSplit split = new NumberAndOperationSplit(expression);
        numbers = split.numbers();
        operands = split.operations();
    }

    public int calculate() {
        int result = numbers.get(0);
        for (int index = 0; index < operands.size(); index++) {
            result = Operation.apply(operands.get(index), result, numbers.get(index + 1));
        }

        return result;
    }
}
