package baseball.application;

import baseball.application.dto.BaseBallGameRequest;
import baseball.application.dto.BaseBallGameResponse;
import baseball.domain.Computer;
import baseball.domain.Player;

public class BaseBallGameService {

    public BaseBallGameResponse inning(BaseBallGameRequest request) {
        Computer computer = new Computer();
        String playerNumber = request.getPlayerNumbers();
        Player player = new Player(playerNumber);

        player.inningResult(computer.getAnswerNumbers());
        player.summarizeResult();

        BaseBallGameResponse response = new BaseBallGameResponse(
                player.getStrikeCount(), player.getBallCount(), player.hasFourBall()
        );
        return response;
    }
}
