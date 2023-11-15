package coordinate;

import util.Terminal;

import java.util.Arrays;

public class Line implements GeometricElement {
    private final Point[] points;

    public Line(Point[] in) {
        points = Arrays.copyOf(in, 2);
    }

    public Line(Point point1, Point point2) {
        this(new Point[]{point1, point2});
    }

    public Point[] getEndPoints() {
        return Arrays.copyOf(points, 2);
    }

    @Override
    public double calculate() {
        int dx = points[0].getX() - points[1].getX();
        int dy = points[0].getY() - points[1].getY();

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    @Override
    public void printCalculateResult() {
        String message = String.format("두 점 사이의 거리는 %.6f", this.calculate());
        Terminal.out(message);
    }
}
