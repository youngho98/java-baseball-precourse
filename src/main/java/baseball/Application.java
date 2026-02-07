package baseball;

import baseball.controller.GameController;
import baseball.domain.NumbersGenerator;
import baseball.domain.Umpire;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(
                new NumbersGenerator(),
                new Umpire(),
                new InputView(),
                new OutputView()
        );

        gameController.run();
    }
}
