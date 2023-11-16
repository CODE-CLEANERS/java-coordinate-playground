package coordinate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static coordinate.PointConverter.getPoints;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LineTest {

    @ParameterizedTest
    @CsvSource(value = {"[10,14]:[14,15]"}, delimiter = ':')
    void 생성(String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);
        Line line = new Line(points);

        // when
        Point[] result = line.getEndPoints();

        // then
        assertThat(result).containsExactly(points);
    }

    @ParameterizedTest
    @CsvSource(value = {"[10,14]:[10,15]"}, delimiter = ':')
    void 거리_계산(String xStr, String yStr) {
        // given
        Point[] points = getPoints(xStr, yStr);
        Line line = new Line(points);

        // when
        double result = line.calculate();

        // then
        assertThat(result).isEqualTo(6.403, offset(0.009));
    }
}