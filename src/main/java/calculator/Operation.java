package calculator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public enum Operation {

    ADD         ("+", (number1, number2) -> (number1 + number2)),
    SUBTRACT    ("-", (number1, number2) -> (number1 - number2)),
    MULTIPLY    ("*" , (number1, number2) -> (number1 * number2)),
    DIVIDE      ("/", (number1, number2) -> {
        if(number2 == 0){
            throw new ArithmeticException("나눗셈 수행 불가. 제수값 : 0");
        }
        return number1 / number2
            });

    private final String operation;
    private final BiFunction<Integer, Integer, Integer> operationFunction;

    private Operation(String operation, BiFunction<Integer, Integer, Integer> operationFunction) {
        this.operation = operation;
        this.operationFunction = operationFunction;
    }

    public static Integer apply(String inputOperation, Integer number1, Integer number2) {
        Operation chosenOperation = Arrays.stream(values())
                .filter(thisOperation -> thisOperation.operation.equals(inputOperation))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("연산자가 존재하지 않습니다."));

        return choicedOperation.operationFunction.apply(number1, number2);
    }
}

