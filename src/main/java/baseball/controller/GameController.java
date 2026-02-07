package baseball.controller;

import baseball.domain.Hint;
import baseball.domain.NumbersGenerator;
import baseball.domain.PlayerGuess;
import baseball.domain.Umpire;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final NumbersGenerator numbersGenerator;
    private final Umpire umpire;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(NumbersGenerator numbersGenerator, Umpire umpire,
                          InputView inputView, OutputView outputView) {
        this.numbersGenerator = numbersGenerator;
        this.umpire = umpire;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        while (true) {
            playOneGame();

            if (isRestart()) {
                continue;
            }
            return;
        }
    }

    private void playOneGame() {
        int[] answer = numbersGenerator.generate();

        while (true) {
            Hint hint = playOneTurn(answer);

            if (hint == null) {
                continue;
            }

            if (hint.isThreeStrike()) {
                outputView.printGameEnd();
                return;
            }
        }
    }

    private Hint playOneTurn(int[] answer) {
        try {
            PlayerGuess guess = readGuess();
            Hint hint = umpire.judge(answer, guess.asArray());
            outputView.printHint(hint);
            return hint;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage();
            return null;
        }
    }

    private PlayerGuess readGuess() {
        String input = inputView.readGuess();
        return PlayerGuess.from(input);
    }

    private boolean isRestart() {
        try {
            String input = inputView.readRestartCommand();
            return parseRestartCommand(input);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage();
            return isRestart();
        }
    }

    private boolean parseRestartCommand(String input) {
        if ("1".equals(input)) {
            return true;
        }

        if ("2".equals(input)) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
