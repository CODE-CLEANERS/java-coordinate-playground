package coordinate.geometricelement;

import util.Terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static exception.ExceptionMessage.NO_SHAPE;

public class Rectangle extends Shape implements GeometricElement {

    protected Rectangle(Point[] in) {
        super(in);
        List<Point> points = new ArrayList<>(4);
        Collections.addAll(points, in);
        getSortedVertexes(points);
        validate();
    }

    /**
     * 네 점을 다음과 같이 대칭 점끼리 묶어서 정렬
     * 1. 한 점을 고른다
     * 2. 다른 세 점 중 앞서 정한 한 점과 가장 멀리 있는 한점을 찾는다 (고른 점과 대칭점)
     * 3. 위의 두 점을 순서 대로 배열에 저장
     * 4. 나머지 두 점을 이어서 배열에 저장 (나머지 두점은 또 서로의 대칭점)
     * @param points 입력 받은 점들
     */
    private void getSortedVertexes(List<Point> points) {
        Point base = points.get(0);
        points.remove(base);

        Point opposite = points.get(0);
        double maxLength = new Line(base, opposite).calculate();
        for (int i = 1; i < points.size(); i++) {
            double compareLength = new Line(base, points.get(i)).calculate();

            if (maxLength < compareLength) {
                maxLength = compareLength;
                opposite = points.get(i);
            }
        }

        points.remove(opposite);

        vertexes[0] = base;
        vertexes[1] = opposite;
        vertexes[2] = points.get(0);
        vertexes[3] = points.get(1);
    }

    @Override
    public void validate() {
        boolean result1;
        boolean result2;

        result1 = isRightAngle(new Line(vertexes[0], vertexes[2]), new Line(vertexes[0], vertexes[3]));
        result2 = isRightAngle(new Line(vertexes[1], vertexes[2]), new Line(vertexes[1], vertexes[3]));

        if (!(result1 && result2)) {
            throw new ArithmeticException(String.format(NO_SHAPE.getMessage(), this.getClass().getSimpleName()));
        }
    }

    private boolean isRightAngle(Line line1, Line line2) {
        Point[] p1 = line1.getEndPoints();
        double angle1 = getAngle(p1[0], p1[1]);

        Point[] p2 = line2.getEndPoints();
        double angle2 = getAngle(p2[0], p2[1]);

        double betweenAngle = Math.abs(angle1 - angle2);
        return betweenAngle == 90;
    }

    private double getAngle(Point start, Point end) {
        double dx = start.getX() - end.getX();
        double dy = start.getY() - end.getY();

        double angle = Math.atan2(dy, dx) * (180.0 / Math.PI);
        return Math.abs(angle);
    }

    @Override
    public Point[] getVertex() {
        return Arrays.copyOf(vertexes, 4);
    }

    @Override
    public double calculate() {
        int width = vertexes[0].getX() - vertexes[2].getX();
        int height = vertexes[0].getY() - vertexes[3].getY();
        return width * height;
    }

    @Override
    public void printCalculateResult() {
        String message = String.format("사각형 넓이는 %.0f", this.calculate());
        Terminal.out(message);
    }
}
