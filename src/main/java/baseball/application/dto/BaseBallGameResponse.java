package baseball.application.dto;

public class BaseBallGameResponse {
    private int strikeCount;
    private int ballCount;
    private boolean hasFourBall;

    public BaseBallGameResponse(int strikeCount, int ballCount, boolean hasFourBall) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.hasFourBall = hasFourBall;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isHasFourBall() {
        return hasFourBall;
    }

    @Override
    public String toString() {
        return "{" +
                "strikeCount=" + strikeCount +
                ", ballCount=" + ballCount +
                ", isFourBall=" + hasFourBall +
                '}';
    }
}
