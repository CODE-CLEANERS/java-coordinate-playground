package study;

import Figure.Line;
import domain.Point;
import domain.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LineTest {

    @Test
    @DisplayName("선_길이_확인")
    void 선_길이_Test() {

        List<Point> points = new ArrayList<>();

        points.add(Point.newInstance(10, 10));
        points.add(Point.newInstance(10, 15));

        Line line = new Line(Points.newInstance(points));
        double len = line.calculate();
        Assertions.assertThat(5.0).isEqualTo(len);

    }
}
