package coordinate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static coordinate.PointConverter.getPoints;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void beforeEach() {
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"[24,10]:[10,24]", "[1,5]:[5,1]"}, delimiter = ':')
    void 좌표_입력_테스트_범위값(String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);

        // when
        boolean result = calculator.validatePoints(points);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"[25,10]:[10,25]", "[0,23]:[13,0]", "[-1,8]:[17,-1]"}, delimiter = ':')
    void 좌표_입력_테스트_범위_초과(String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);

        // when
        boolean result = calculator.validatePoints(points);

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(14,15):[10,14]:[10,15]"}, delimiter = ':')
    void 좌표_입력_테스트(String input, String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);


        // when
        Point[] result = calculator.toPoints(input);


        // then
        assertThat(result).contains(points);
    }

    @Test
    void 좌표_두개_입력() {
        // given
        Point[] points = new Point[2];
        points[0] = new Point(10, 10);
        points[1] = new Point(14, 15);

        // when
        Shape result = calculator.getShape(points);

        // then
        assertThat(result.getClass()).isEqualTo(Line.class);
    }
}