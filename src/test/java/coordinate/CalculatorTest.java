package coordinate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static coordinate.util.Message.NOT_ENOUGH_INPUT;
import static coordinate.util.Message.OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class CalculatorTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        System.setIn(System.in);
        output.reset();
    }

    @ParameterizedTest
    @DisplayName("범위_밖의_값_입력")
    @ValueSource(strings = {"(25,11)-(14,15)", "(12,25)-(14,15)", "(12,13)-(25,15)", "(12,13)-(14,25)",
            "(0,11)-(14,15)", "(12,0)-(14,15)", "(12,13)-(0,15)", "(12,13)-(14,0)"})
    void inputOutOfRange(String input) throws IOException {
        // given
        Calculator calculator = new Calculator();
        input(input);

        // when, then
        assertThat(calculator.input()).isEqualTo(false);
        assertThat(output.toString()).contains(OUT_OF_RANGE.toString());
    }

    @ParameterizedTest
    @DisplayName("허용되지_않는_개수의_축_좌표값_입력")
    @ValueSource(strings = {"(1,2,3)-(1,2)", "(1,2)-(1,2,3)", "(1)-(1,2)", "()-(1,2)"})
    void inputNotAllowSize(String input) throws IOException {
        // given
        Calculator calculator = new Calculator();
        input(input);

        // when, then
        assertThat(calculator.input()).isEqualTo(false);
        assertThat(output.toString()).contains(NOT_ENOUGH_INPUT.toString());
    }

    @Test
    @DisplayName("두_점_사이의_거리")
    void lineLength() throws IOException {
        // given
        Calculator calculator = new Calculator();
        input("(10,10)-(14,15)");

        // when
        double length = calculator.calculate();

        // then
        assertThat(length).isEqualTo(6.403124, offset(0.00099));
    }

    private void input(String value) {
        InputStream is = new ByteArrayInputStream(value.getBytes());
        System.setIn(is);
    }
}
