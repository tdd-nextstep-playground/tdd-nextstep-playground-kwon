package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("문자열 계산기 테스트")
public class CalculatorTest {
    private int number1;
    private int number2;

    @BeforeEach
    void setUp() {
        number1 = 1;
        number2 = 2;
    }

    @Test
    @DisplayName("두 숫자를 더한다.")
    void add() {
        Assertions.assertThat(Operation.apply("+", number1, number2)).isEqualTo(3);
    }

    @Test
    @DisplayName("두 숫자를 뺀다.")
    void subtract() {
        Assertions.assertThat(Operation.apply("-", number2, number1)).isEqualTo(1);
    }

    @Test
    @DisplayName("두 숫자를 곱한다.")
    void multiply() {
        Assertions.assertThat(Operation.apply("*", number1, number2)).isEqualTo(2);
    }

    @Test
    @DisplayName("두 숫자를 나눈다.")
    void divide() {
        Assertions.assertThat(Operation.apply("/", number1, number2)).isEqualTo(0);
    }

    @Test
    @DisplayName("식에 존재하는 숫자를 반환한다.")
    void getNumbers() {
        String given = "2 + 3 * 4 / 2";
        NumberAndOperationSplit split = new NumberAndOperationSplit(given);

        List<Integer> numbers = split.numbers();

        numbers.forEach(thisNumber -> System.out.println("number : " + thisNumber));
    }

    @Test
    @DisplayName("식에 존재하는 연산을 반환한다.")
    void getOperations() {
        String given = "2 + 3 * 4 / 2";
        NumberAndOperationSplit split = new NumberAndOperationSplit(given);

        List<String> operations = split.operations();

        operations.forEach(thisOperation -> System.out.println("operation : " + thisOperation));
    }

    @Test
    @DisplayName("사칙 연산을 진행한다.")
    void calculate() {
        String given = "2 + 3 * 4 / 2";
        int expected = 10;
        Calculator calculator = new Calculator(given);

        Assertions.assertThat(calculator.calculate()).isEqualTo(expected);
    }
}
