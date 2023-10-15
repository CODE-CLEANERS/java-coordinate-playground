package study;

import Figure.Line;
import Figure.Square;
import Figure.Triangle;
import domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Constants;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    // 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분
    @Test
    @DisplayName("입력 좌표 포맷을 확인")
    void 입력_좌표_포맷_Test() {

        Throwable exception1 = assertThrows(RuntimeException.class, () -> {
            InputView.validInputFormat("(3,4)");
        });
        assertEquals(Constants.INPUT_FORMAT_CHECK, exception1.getMessage());

        InputView.validInputFormat("(3,4)-(3,5)");

        Throwable exception3 = assertThrows(RuntimeException.class, () -> {
            InputView.validInputFormat("(3,4)-(3,5)-(3,6)-(3,7)");
        });
        assertEquals(Constants.INPUT_FORMAT_CHECK, exception3.getMessage());

        Throwable exception4 = assertThrows(RuntimeException.class, () -> {
            InputView.validInputFormat("(3,4)-(3,5,8)");
        });
        assertEquals(Constants.INPUT_FORMAT_CHECK, exception4.getMessage());

        Throwable exception5 = assertThrows(RuntimeException.class, () -> {
            InputView.validInputFormat("(3,4)-(3,g)");
        });
        assertEquals(Constants.INPUT_FORMAT_CHECK, exception5.getMessage());

    }

    // X, Y좌표 모두 최대 24까지만 입력
    @Test
    @DisplayName("입력_좌표_범위_확인")
    void 입력_좌표_범위_Test() {

        Point.initPoint(0, 24);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Point.initPoint(-1, 24);
        });
        assertEquals(Constants.INPUT_RANGE_CHECK, exception.getMessage());

        Throwable exception2 = assertThrows(RuntimeException.class, () -> {
            Point.initPoint(0, 25);
        });
        assertEquals(Constants.INPUT_RANGE_CHECK, exception2.getMessage());

    }

    // 선 길이
    @Test
    @DisplayName("선_길이_확인")
    void 선_길이_Test() {

        List<Point> points = new ArrayList<>();

        points.add(Point.initPoint(10, 10));
        points.add(Point.initPoint(10, 15));

        Line line = new Line(Points.initPoints(points));
        double len = line.calculate();
        Assertions.assertThat(5.0).isEqualTo(len);

    }

    // 사각형 넓이
    @Test
    @DisplayName("사각형_넓이_확인")
    void 사각형_넓이_Test() {

        List<Point> points = new ArrayList<>();

        points.add(Point.initPoint(10, 10));
        points.add(Point.initPoint(10, 15));
        points.add(Point.initPoint(15, 15));
        points.add(Point.initPoint(15, 10));

        Square square = new Square(Points.initPoints(points));
        double area = square.calculate();
        Assertions.assertThat(25.0).isEqualTo(area);

    }

    // 삼각형
    @Test
    @DisplayName("삼각형_넓이_확인")
    void 삼각형_넓이_Test() {

        List<Point> points = new ArrayList<>();

        points.add(Point.initPoint(0, 10));
        points.add(Point.initPoint(0, 0));
        points.add(Point.initPoint(10, 0));

        Triangle triangle = new Triangle(Points.initPoints(points));
        double area = triangle.calculate();
        Assertions.assertThat(50.0).isEqualTo(area);

    }
}
