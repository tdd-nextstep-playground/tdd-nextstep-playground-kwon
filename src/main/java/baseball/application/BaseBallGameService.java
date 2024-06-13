package baseball.application;

import baseball.application.dto.BaseBallGameRequest;
import baseball.application.dto.BaseBallGameResponse;
import baseball.domain.Computer;
import baseball.domain.Player;

import java.util.List;

public class BaseBallGameService {
    private static final Computer computer = new Computer();
    private static final List<String> answerNumber = computer.getAnswerNumbers();

    public BaseBallGameResponse inning(BaseBallGameRequest request) {
        String playerNumber = request.getPlayerNumbers();
        Player player = new Player(playerNumber);

        player.inningResult(answerNumber);
        player.summarizeResult();

        BaseBallGameResponse response = new BaseBallGameResponse(
                player.getStrikeCount(), player.getBallCount(), player.hasFourBall()
        );
        return response;
    }
}
