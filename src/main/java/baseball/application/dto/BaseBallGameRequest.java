package baseball.application.dto;

public class BaseBallGameRequest {
    private String playerNumbers;

    public BaseBallGameRequest(String playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public String getPlayerNumbers() {
        return playerNumbers;
    }
}
