package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("야구 게임 룰 도메인 테스트")
public class BaseBallRuleTest {
    private Computer computer;
    private List<String> answerNumbers;

    @BeforeEach
    void setUp() {
        computer = new Computer(List.of("1", "2", "3"));
        answerNumbers = new ArrayList<>(computer.getAnswerNumbers());
    }

    @Nested
    @DisplayName("해피 케이스 테스트")
    class HappyCaseTest {
        @Test
        @DisplayName("같은 자리에 같은 수가 있으면 스트라이크이다.")
        void strike() {
            int playerNumberIndex = 0;
            String playerNumber = "1";

            BaseBallRule result = BaseBallRule.findResult(answerNumbers, playerNumberIndex, playerNumber);

            Assertions.assertThat(result == BaseBallRule.STRIKE);
        }

        @Test
        @DisplayName("같은 수가 다른 자리에 있으면 볼이다.")
        void ball() {
            int playerNumberIndex = 1;
            String playerNumber = "1";

            BaseBallRule result = BaseBallRule.findResult(answerNumbers, playerNumberIndex, playerNumber);

            Assertions.assertThat(result == BaseBallRule.BALL);
        }

        @Test
        @DisplayName("같은 수가 존재하지 않을 경우 포볼이다.")
        void fourBall() {
            int playerNumberIndex = 1;
            String playerNumber = "1";

            BaseBallRule result = BaseBallRule.findResult(answerNumbers, playerNumberIndex, playerNumber);

            Assertions.assertThat(result == BaseBallRule.FOUR_BALL);
        }
    }

    @Nested
    @DisplayName("배드 케이스 테스트")
    class BaseCaseTest {

        @Test
        @DisplayName("플레이어의 숫자 인덱스가 3보다 클 경우 예외가 발생한다.")
        void exception_playerNumber_index() {
            Assertions.assertThatThrownBy(
                    () -> BaseBallRule.findResult(answerNumbers, 4, "1")
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("플레이어의 숫자가 9보다 클 경우 예외가 발생한다.")
        void exception_playerNumber() {
            Assertions.assertThatThrownBy(
                    () -> BaseBallRule.findResult(answerNumbers, 1, "10")
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
