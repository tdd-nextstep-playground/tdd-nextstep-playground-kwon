package baseball.interfaces;

import java.util.Scanner;

public class InputView {

    public String inputPlayerNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String playerNumbers = scanner.nextLine();

        return playerNumbers;
    }
}
