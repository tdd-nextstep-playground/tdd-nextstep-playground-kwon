package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberAndOperationSplit {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private String[] elements;

    public NumberAndOperationSplit(String expression) {
        elements = splitByWhiteSpace(expression);
    }

    private String[] splitByWhiteSpace(String expression) {
        return expression.split(" ");
    }

    public List<Integer> numbers() {
        return Arrays.stream(elements)
                .filter(thisElement -> isNumber(thisElement))
                .map(thisElement -> Integer.valueOf(thisElement))
                .collect(Collectors.toList());
    }

    public List<String> operations() {
        return Arrays.stream(elements)
                .filter(thisElement -> isOperation(thisElement))
                .collect(Collectors.toList());
    }

    private static boolean isOperation(String element) {
        return !isNumber(element);
    }

    private static boolean isNumber(String element) {
        return NUMBER_PATTERN.matcher(element).find();
    }
}
