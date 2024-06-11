package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

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
    @DisplayName("빈 공백 문자열을 기준으로 문자들을 분리한다.")
    void split() {
        String expression = "2 + 3 * 4 / 2";

        String[] elements = WhiteSpaceSplit.split(expression);

        for (String element : elements) {
            System.out.println("element : " + element);
        }
    }

    @Test
    @DisplayName("두 숫자를 더한다.")
    void add() {
        Assertions.assertThat(Operation.ADD.apply("+", number1, number2)).isEqualTo(3);
    }

    @Test
    @DisplayName("두 숫자를 뺀다.")
    void subtract() {
        Assertions.assertThat(Operation.SUBTRACT.apply("-", number2, number1)).isEqualTo(1);
    }

    @Test
    @DisplayName("두 숫자를 곱한다.")
    void multiply() {
        Assertions.assertThat(Operation.MULTIPLY.apply("*", number1, number2)).isEqualTo(2);
    }

    @Test
    @DisplayName("두 숫자를 나눈다.")
    void divide() {
        Assertions.assertThat(Operation.DIVIDE.apply("/", number1, number2)).isEqualTo(0);
    }
}
