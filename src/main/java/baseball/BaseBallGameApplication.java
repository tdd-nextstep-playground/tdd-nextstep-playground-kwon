package baseball;

import baseball.interfaces.BaseBallGameController;

public class BaseBallGameApplication {

    public static void main(String[] args) {
        BaseBallGameController controller = new BaseBallGameController();

        runUntilGameEnd(controller);

        int gameReStartFlag = controller.gameReStart();
        if (gameReStartFlag == 1) {
            runUntilGameEnd(controller);
        }
    }

    private static void runUntilGameEnd(BaseBallGameController controller) {
        int strikeCount = controller.gameStart();

        while (strikeCount < 3) {
            strikeCount = controller.gameStart();
        }

        controller.endGame();
    }
}
