package baseball.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Computer {
    private static String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static Random random = new Random();

    private final Set<String> answerNumbers;

    public Computer() {
        this.answerNumbers = createAnswerNumbers();
    }

    public Set<String> getAnswerNumbers() {
        return answerNumbers;
    }

    private Set<String> createAnswerNumbers() {
        Set<String> answerNumbers = new HashSet<>();
        while (answerNumbers.size() < 3) {
            int index = random.nextInt(numbers.length);
            answerNumbers.add(numbers[index]);
        }

        return answerNumbers;
    }
}
