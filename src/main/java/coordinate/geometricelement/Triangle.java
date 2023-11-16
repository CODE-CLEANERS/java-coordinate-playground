package coordinate.geometricelement;

import util.Terminal;

import java.util.Arrays;

import static exception.ExceptionMessage.NO_SHAPE;

public class Triangle extends Shape implements GeometricElement {

    protected Triangle(Point[] in) {
        super(in);
        System.arraycopy(in, 0, vertexes, 0, in.length);
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
            throw new ArithmeticException(String.format(NO_SHAPE.getMessage(), this.getClass().getSimpleName()));
        }
    }

    @Override
    public Point[] getVertex() {
        return Arrays.copyOf(vertexes, 3);
    }
}
