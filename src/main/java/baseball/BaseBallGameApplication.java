package baseball;

import baseball.interfaces.BaseBallGameController;

public class BaseBallGameApplication {

    public static void main(String[] args) {
        BaseBallGameController controller = new BaseBallGameController();

        controller.gameStart();
    }
}
