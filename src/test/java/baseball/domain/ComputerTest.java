package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


@DisplayName("컴퓨터 도메인 테스트")
public class ComputerTest {

    @Test
    @DisplayName("1에서 9까지 서로 다른 수로 이루어진 3자리의 수를 생성한다.")
    void createAnswerNumbers() {
        Computer computer = new Computer();
        List<String> answerNumbers = computer.getAnswerNumbers();

        answerNumbers.stream()
                .forEach(thisNumber -> System.out.println("number : " + thisNumber));
        Assertions.assertThat(answerNumbers.size() == 3).isTrue();
    }
}
