package app;

import view.InputView;
import view.OutputView;

import java.io.IOException;

public class FigureGame {
    private FigureGame() {
        throw new IllegalArgumentException();
    }

    public static void game() throws IOException {
        OutputView.printGetInput();
        String[] userInputDots = InputView.getInput();
        OutputView.printOutput(userInputDots);
    }
}
