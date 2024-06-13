package baseball.interfaces;

import baseball.application.BaseBallGameService;
import baseball.application.dto.BaseBallGameRequest;
import baseball.application.dto.BaseBallGameResponse;

public class BaseBallGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final BaseBallGameService service;

    public BaseBallGameController() {
        inputView = new InputView();
        resultView = new ResultView();
        service = new BaseBallGameService();
    }

    public void gameStart() {
        String playerNumbers = inputView.inputPlayerNumbers();
        BaseBallGameRequest request = new BaseBallGameRequest(playerNumbers);
        BaseBallGameResponse response = service.inning(request);
        resultView.print(response);
    }
}
