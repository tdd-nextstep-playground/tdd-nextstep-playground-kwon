package baseball.application;

import baseball.application.dto.BaseBallGameRequest;
import baseball.application.dto.BaseBallGameResponse;
import baseball.domain.BaseBallRule;
import baseball.domain.Computer;
import baseball.domain.Player;

import java.util.List;

public class BaseBallGameService {

    public BaseBallGameResponse inning(BaseBallGameRequest request) {
        Computer computer = new Computer();
        String playerNumber = request.getPlayerNumbers();
        Player player = new Player(playerNumber);

        List<BaseBallRule> playerResults = player.result(computer.getAnswerNumbers());

        BaseBallGameResponse response = createResponse(playerResults);
        return response;
    }

    private BaseBallGameResponse createResponse(List<BaseBallRule> playerResult) {
        int strikeCount = 0;
        int ballCount = 0;
        boolean isFourBall = false;

        for (BaseBallRule baseBallRule : playerResult) {
            if (baseBallRule == BaseBallRule.STRIKE) {
                strikeCount++;
            }
            if (baseBallRule == BaseBallRule.BALL) {
                ballCount++;
            }
            if (baseBallRule == BaseBallRule.FOUR_BALL) {
                isFourBall = true;
            }
        }

        return new BaseBallGameResponse(strikeCount, ballCount, isFourBall);
    }
}
