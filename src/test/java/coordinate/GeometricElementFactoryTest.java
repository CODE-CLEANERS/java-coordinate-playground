package coordinate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GeometricElementFactoryTest {

    @Test
    void 좌표_두개_입력() {
        // given
        Point[] points = new Point[2];
        points[0] = new Point(10, 10);
        points[1] = new Point(14, 15);

        // when
        GeometricElement result = GeometricFactory.getGeometricElement(points);

        // then
        assertThat(result.getClass()).isEqualTo(Line.class);
    }

    @Test
    void 좌표_네개_입력() {
        // given
        Point[] points = new Point[4];
        points[0] = new Point(10, 10);
        points[1] = new Point(22, 10);
        points[2] = new Point(22, 18);
        points[3] = new Point(10, 18);

        // when
        GeometricElement result = GeometricFactory.getGeometricElement(points);

        // then
        assertThat(result.getClass()).isEqualTo(Rectangle.class);
    }

    @Test
    void 좌표_세개_입력() {
        // given
        Point[] points = new Point[3];
        points[0] = new Point(10, 10);
        points[1] = new Point(14, 15);
        points[2] = new Point(20, 8);

        // when
        GeometricElement result = GeometricFactory.getGeometricElement(points);

        // then
        assertThat(result.getClass()).isEqualTo(Triangle.class);
    }
}
