package baseball.domain;

public class Umpire {

    private static final int SIZE = 3;

    public Hint judge(int[] answer, int[] guess) {
        int strike = countStrike(answer, guess);
        int ball = countBall(answer, guess);
        return new Hint(strike, ball);
    }

    private int countStrike(int[] answer, int[] guess) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    private int countBall(int[] answer, int[] guess) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (guess[i] != answer[i] && contains(answer, guess[i])) {
                count++;
            }
        }
        return count;
    }

    private boolean contains(int[] numbers, int candidate) {
        for (int n : numbers) {
            if (candidate == n) {
                return true;
            }
        }
        return false;
    }
}
