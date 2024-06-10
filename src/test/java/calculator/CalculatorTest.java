package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 계산기 테스트")
public class CalculatorTest {

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
    void separateNumberAndOperation() {
        Integer number1 = 1;
        Integer number2 = 2;
        Integer expected = 3;

        Assertions.assertThat(Operation.PLUS.apply("+", number1, number2)).isEqualTo(expected);
    }
}
