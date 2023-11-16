package coordinate.geometricelement;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static coordinate.PointConverter.getPoints;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {

    @ParameterizedTest
    @CsvSource(value = {"[10,14,20]:[10,15,8]"}, delimiter = ':')
    void 생성_성공(String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);

        // when
        Triangle triangle = new Triangle(points);
        Point[] result = triangle.getVertex();

        // then
        assertThat(result).contains(points);
    }

    @ParameterizedTest
    @CsvSource(value = {"[10,10,10]:[10,15,8]"}, delimiter = ':')
    void 생성_실패(String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);

        // when
        // then
        ArithmeticException result = assertThrows(ArithmeticException.class,
                () -> new Triangle(points));

        assertThat(result.getMessage()).contains("No Triangle");
    }

    @ParameterizedTest
    @CsvSource(value = {"[10,14,20]:[10,15,8]"}, delimiter = ':')
    void 넓이_계산(String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);
        Triangle triangle = new Triangle(points);

        // when
        double result = triangle.calculate();

        // then
        assertThat(result).isEqualTo(29, offset(0.1));
    }
}
