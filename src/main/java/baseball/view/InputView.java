package baseball.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String readGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        return SCANNER.nextLine();
    }

    public String readRestartCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return SCANNER.nextLine();
    }
}
