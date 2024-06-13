package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("플레이어 도메인 테스트")
public class PlayerTest {
    private Computer computer;
    private List<String> answerNumbers;

    @BeforeEach
    void setUp() {
        computer = new Computer(List.of("4", "2", "5"));
        answerNumbers = new ArrayList<>(computer.getAnswerNumbers());
    }

    @Test
    @DisplayName("플레이어는 3스트라이크이다.")
    void threeStrike() {
        Player player = new Player(List.of("4", "2", "5"));

        List<BaseBallRule> playerResult = player.inningResult(answerNumbers);

        printResult(playerResult);
    }

    @Test
    @DisplayName("플레이어의 숫자가 123일 경우 1 스트라이크이다.")
    void oneStrike() {
        Player player = new Player(List.of("1", "2", "3"));

        List<BaseBallRule> playerResult = player.inningResult(answerNumbers);

        printResult(playerResult);
    }

    @Test
    @DisplayName("플레이어의 숫자가 456일 경우 1볼 1스트라이크이다.")
    void oneStrike_and_oneBall() {
        Player player = new Player(List.of("4", "5", "6"));

        List<BaseBallRule> playerResult = player.inningResult(answerNumbers);

        printResult(playerResult);
    }

    @Test
    @DisplayName("플레이어의 숫자가 789일 경우 포볼이다.")
    void fourBall() {
        Player player = new Player(List.of("7", "8", "9"));

        List<BaseBallRule> playerResult = player.inningResult(answerNumbers);

        printResult(playerResult);
    }

    private void printResult(List<BaseBallRule> playerResult) {
        for (BaseBallRule baseBallRule : playerResult) {
            System.out.println("결과 : " + baseBallRule);
        }
    }
}
