package baseball.application.dto;

public class BaseBallGameResponse {
    private int strikeCount;
    private int ballCount;
    private boolean isFourBall;

    public BaseBallGameResponse(int strikeCount, int ballCount, boolean isFourBall) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.isFourBall= isFourBall;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isFourBall() {
        return isFourBall;
    }

    @Override
    public String toString() {
        return "{" +
                "strikeCount=" + strikeCount +
                ", ballCount=" + ballCount +
                ", isFourBall=" + isFourBall +
                '}';
    }
}
