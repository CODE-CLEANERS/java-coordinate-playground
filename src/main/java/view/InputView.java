package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private InputView() {
        throw new IllegalArgumentException();
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String[] getInput() throws IOException {
        String userInput = br.readLine();
        return userInput.split("-");
    }
}
