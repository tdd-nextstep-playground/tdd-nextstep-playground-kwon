package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<String> numbers;
    private List<BaseBallRule> result = new ArrayList<>();
    private int strikeCount = 0;
    private int ballCount = 0;
    private boolean hasFourBall = false;

    public Player(String numbers) {
        String[] splitNumbers = numbers.split("");
        this.numbers = Arrays.stream(splitNumbers)
                .collect(Collectors.toList());
    }

    public Player(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<BaseBallRule> inningResult(List<String> answerNumbers) {
        int numberIndex = 0;

        for (String number : numbers) {
            result.add(BaseBallRule.findResult(answerNumbers, numberIndex, number));
            numberIndex++;
        }

        return result;
    }

    public void summarizeResult() {
        for (BaseBallRule baseBallRule : result) {
            strikeCount = strikeCount + BaseBallRule.isStrike(baseBallRule);
            ballCount = ballCount + BaseBallRule.isBall(baseBallRule);
            hasFourBall = BaseBallRule.isFourBall(baseBallRule);
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean hasFourBall() {
        return hasFourBall;
    }
}
