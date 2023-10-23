package study;

import Figure.Square;
import domain.Point;
import domain.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SquareTest {

    @Test
    @DisplayName("사각형_넓이_확인")
    void 사각형_넓이_Test() {

        List<Point> points = new ArrayList<>();

        points.add(Point.newInstance(10, 10));
        points.add(Point.newInstance(10, 15));
        points.add(Point.newInstance(15, 15));
        points.add(Point.newInstance(15, 10));

        Square square = new Square(Points.newInstance(points));
        double area = square.calculate();
        Assertions.assertThat(25.0).isEqualTo(area);

    }
}
