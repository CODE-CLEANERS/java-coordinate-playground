package coordinate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("잘못된_값_입력")
    void failInput() throws IOException {
        // given
        Calculator calculator = new Calculator();
        input("(25,10)-(14,15)");

        // when, then
        assertThat(calculator.input()).isEqualTo(false);
        assertThat(output.toString()).contains("X, Y좌표 모두 최소 0, 최대 24까지만 입력할 수 있습니다.");
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
