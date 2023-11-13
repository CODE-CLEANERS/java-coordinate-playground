package coordinate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static coordinate.PointConverter.getPoints;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    @ParameterizedTest
    @CsvSource(value = {"[10,22,22,10]:[10,10,18,18]"}, delimiter = ':')
    void 생성_성공(String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);

        // when
        Rectangle rectangle = new Rectangle(points[0], points[1], points[2], points[3]);
        Point[] result = rectangle.getVertex();

        // then
        assertThat(result).contains(points);
    }

    @ParameterizedTest
    @CsvSource(value = {"[10,22,22,10]:[10,10,19,18]"}, delimiter = ':')
    void 생성_실패(String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);

        // when
        // then
        ArithmeticException result = assertThrows(ArithmeticException.class,
                () -> new Rectangle(points[0], points[1], points[2], points[3]));

        assertThat(result.getMessage()).contains("No Rectangle");
    }

    @ParameterizedTest
    @CsvSource(value = {"[10,22,22,10]:[10,10,18,18]"}, delimiter = ':')
    void 넓이_계산(String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);
        Rectangle rectangle = new Rectangle(points[0], points[1], points[2], points[3]);

        // when
        double result = rectangle.calculate();

        // then
        assertThat(result).isEqualTo(96, offset(0.1));
    }
}
