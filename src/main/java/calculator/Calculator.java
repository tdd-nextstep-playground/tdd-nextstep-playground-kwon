package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> numbers = new ArrayList<>();
    private List<String> operations = new ArrayList<>();

    public Calculator(String expression) {
        NumberAndOperationSplit split = new NumberAndOperationSplit(expression);
        numbers = split.numbers();
        operations = split.operations();
    }

    public int calculate() {
        int result = numbers.get(0);
        for (int index = 0; index < operations.size(); index++) {
            result = Operation.apply(operations.get(index), result, numbers.get(index + 1));
        }

        return result;
    }
}
