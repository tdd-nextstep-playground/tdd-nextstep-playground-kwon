package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1,2를 split 했을 때 1과 2로 분리된다.")
    void split_comma() {
        String stringNumbers = "1,2";

        String[] splitNumbers = stringNumbers.split(",");

        Assertions.assertThat(splitNumbers).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환된다.")
    void split_comma_onlyOne() {
        String numberOne = "1";

        String[] splitNumbers = numberOne.split(",");

        Assertions.assertThat(splitNumbers).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 1,2를 반환한다.")
    void subString() {
        String given = "(1,2)";

        String result = given.substring(1, given.length() - 1);

        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져온다.")
    void charAt() {
        String given = "abc";

        char result = given.charAt(1);
        char expected = 'b';

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("특정 위치 문자의 인덱스가 넘을 경우 StringIndexOutOfBoundsException이 발생한다.")
    void charAt_exception() {
        Assertions.assertThatThrownBy(
                () -> "abc".charAt(4)
        ).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
