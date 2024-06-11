package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

@DisplayName("Set Collection 학습 테스트")
public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 크기를 확인한다.")
    void size() {
        System.out.println("numbers 크기 : " + numbers.size());
    }

    @Test
    @DisplayName("1, 2, 3의 값이 존재하는지를 확인한다.")
    void contains() {
        Assertions.assertThat(numbers.contains(1)).isTrue();
        Assertions.assertThat(numbers.contains(2)).isTrue();
        Assertions.assertThat(numbers.contains(3)).isTrue();
    }

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    @DisplayName("1, 2, 3의 값이 존재하는지를 확인한다.")
    void contains2(int number) {
        Assertions.assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("입력 값에 따라 결과 값이 다른 경우를 확인한다.")
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String number, String expected) {
        Assertions.assertThat(numbers.contains(Integer.valueOf(number))).isEqualTo(Boolean.valueOf(expected));
    }
}