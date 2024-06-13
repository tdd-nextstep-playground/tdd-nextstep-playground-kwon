package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> numbers;

    public Player(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<BaseBallRule> result(List<String> answerNumbers) {
        int numberIndex = 0;
        List<BaseBallRule> baseBallResults = new ArrayList<>();

        for (String number : numbers) {
            baseBallResults.add(BaseBallRule.findResult(answerNumbers, numberIndex, number));
            numberIndex++;
        }

        return baseBallResults;
    }
}
