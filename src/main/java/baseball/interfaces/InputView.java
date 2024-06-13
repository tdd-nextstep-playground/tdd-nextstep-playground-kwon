package baseball.interfaces;

import java.util.Scanner;

public class InputView {

    public String inputPlayerNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String playerNumbers = scanner.nextLine();

        return playerNumbers;
    }

    public int inputReStart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int restartFlag = scanner.nextInt();

        return restartFlag;
    }
}
