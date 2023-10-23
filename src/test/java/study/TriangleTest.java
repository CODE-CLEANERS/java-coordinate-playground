package study;

import Figure.Triangle;
import domain.Point;
import domain.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleTest {
    @Test
    @DisplayName("삼각형_넓이_확인")
    void 삼각형_넓이_Test() {

        List<Point> points = new ArrayList<>();

        points.add(Point.newInstance(0, 10));
        points.add(Point.newInstance(0, 0));
        points.add(Point.newInstance(10, 0));

        Triangle triangle = new Triangle(Points.newInstance(points));
        double area = triangle.calculate();
        Assertions.assertThat(50.0).isEqualTo(area);

    }
}
