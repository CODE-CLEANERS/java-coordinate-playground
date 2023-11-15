package coordinate;

import util.Terminal;

import java.util.Arrays;

public class Triangle implements GeometricElement, Shape {

    private final Point[] vertexes;

    public Triangle(Point[] in) {
        vertexes = Arrays.copyOf(in, 3);

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
    public void printCalculateResult() {
        String message = String.format("삼각형 넓이는 %.1f", this.calculate());
        Terminal.out(message);
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
