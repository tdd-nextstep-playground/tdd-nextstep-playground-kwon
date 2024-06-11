package calculator;

import java.util.function.BiFunction;

public enum Operation {

    ADD         ("+", (number1, number2) -> (number1 + number2)),
    SUBTRACT    ("-", (number1, number2) -> (number1 - number2)),
    MULTIPLY    ("*" , (number1, number2) -> (number1 * number2)),
    DIVIDE      ("/", (number1, number2) -> (number1 / number2));

    private String operation;
    private BiFunction<Integer, Integer, Integer> operationFunction;

    private Operation(String operation, BiFunction<Integer, Integer, Integer> operationFunction) {
        this.operation = operation;
        this.operationFunction = operationFunction;
    }

    public Integer apply(String operation, Integer number1, Integer number2) {
        return operationFunction.apply(number1, number2);
    }
}

