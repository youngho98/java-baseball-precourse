package baseball.view;

import baseball.domain.Hint;

public class OutputView {

    public void printHint(Hint hint) {
        if (hint.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(buildHintMessage(hint));
    }

    private String buildHintMessage(Hint hint) {
        StringBuilder sb = new StringBuilder();
        appendStrike(sb, hint);
        appendBall(sb, hint);
        return sb.toString();
    }

    private void appendStrike(StringBuilder sb, Hint hint) {
        if (hint.getStrike() > 0) {
            sb.append(hint.getStrike()).append("스트라이크");
        }
    }

    private void appendBall(StringBuilder sb, Hint hint) {
        if (hint.getBall() == 0) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(hint.getBall()).append("볼");
    }

    public void printErrorMessage() {
        System.out.println("[ERROR] 잘못된 입력입니다.");
    }

    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
