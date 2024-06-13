package baseball.interfaces;

import baseball.application.dto.BaseBallGameResponse;

public class ResultView {

    public void print(BaseBallGameResponse response) {
        if (0 < response.getStrikeCount()) {
            System.out.println(String.format("%d볼 %d스트라이크", response.getBallCount(), response.getStrikeCount()));
        }
        else if (0 < response.getBallCount()) {
            System.out.println(String.format("%d볼", response.getBallCount()));
        } else {
            System.out.println("4볼");
        }
    }
}
