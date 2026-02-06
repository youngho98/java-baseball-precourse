package baseball.view;

import baseball.domain.Hint;

public class OutputView {

    public void printHint(Hint hint) {
        if (hint.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        printStrike(hint);
        printBall(hint);
        System.out.println();
    }

    public void printErrorMessage() {
        System.out.println("[ERROR] 잘못된 입력입니다.");
    }

    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    private void printStrike(Hint hint) {
        if (hint.getStrike() > 0) {
            System.out.print(hint.getStrike() + "스트라이크 ");
        }
    }

    private void printBall(Hint hint) {
        if (hint.getBall() > 0) {
            System.out.print(hint.getBall() + "볼 ");
        }
    }
}
