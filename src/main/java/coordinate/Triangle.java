package coordinate;

import java.util.Arrays;

public class Triangle implements GeometricElement, Shape {

    private final Point[] vertexes;

    public Triangle(Point point1, Point point2, Point point3) {
        vertexes = new Point[3];

        vertexes[0] = point1;
        vertexes[1] = point2;
        vertexes[2] = point3;

        validate();
    }

    @Override
    public double calculate() {
        double a = new Line(vertexes[0], vertexes[1]).calculate();
        double b = new Line(vertexes[0], vertexes[2]).calculate();
        double c = new Line(vertexes[1], vertexes[2]).calculate();

        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public void validate() {
        int dx = vertexes[0].getX() - vertexes[1].getX();
        int dy = vertexes[0].getY() - vertexes[1].getY();

        double slope1 = Math.abs((double) dy / dx);

        dx = vertexes[0].getX() - vertexes[2].getX();
        dy = vertexes[0].getY() - vertexes[2].getY();

        double slope2 = Math.abs((double) dy / dx);

        if (slope1 == slope2) {
            throw new ArithmeticException("No Triangle.");
        }
    }

    @Override
    public Point[] getVertex() {
        return Arrays.copyOf(vertexes, 3);
    }
}
