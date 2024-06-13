package baseball.domain;

import java.util.List;

public enum BaseBallRule {

    STRIKE,
    BALL,
    FOUR_BALL;

    BaseBallRule() {}

    public static BaseBallRule findResult(List<String> answerNumbers,
                                                int playerNumberIndex,
                                                String playerNumber)
    {
        checkPlayerParameters(playerNumberIndex, playerNumber);
        if (answerNumbers.get(playerNumberIndex) == playerNumber) {
            return STRIKE;
        }
        if (answerNumbers.contains(playerNumber)) {
            return BALL;
        }
        return FOUR_BALL;
    }

    private static void checkPlayerParameters(int playerNumberIndex, String playerNumber) {
        if (3 < playerNumberIndex) {
            throw new IllegalArgumentException("플레이어의 숫자 인덱스가 3보다 큽니다.");
        }
        if (9 < Integer.valueOf(playerNumber)) {
            throw new IllegalArgumentException("플레이어의 숫자가 9보다 큽니다.");
        }
    }
}
