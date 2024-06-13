package baseball.domain;

import java.util.*;

public class Computer {
    private static String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static Random random = new Random();

    private final List<String> answerNumbers;

    public Computer() {
        this.answerNumbers = createAnswerNumbers();
    }

    public Computer(List<String> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    private List<String> createAnswerNumbers() {
        Set<String> answerNumbers = new HashSet<>();
        while (answerNumbers.size() < 3) {
            int index = random.nextInt(numbers.length);
            answerNumbers.add(numbers[index]);
        }

        return new ArrayList<>(answerNumbers);
    }

    public List<String> getAnswerNumbers() {
        return answerNumbers;
    }
}
