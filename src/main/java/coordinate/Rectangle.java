package coordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rectangle implements GeometricElement, Shape {
    private final Point[] vertexes;

    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        vertexes = new Point[4];
        List<Point> vertexes = new ArrayList<>();
        vertexes.add(point1);
        vertexes.add(point2);
        vertexes.add(point3);
        vertexes.add(point4);
        validate();
        sort(vertexes);
    }

    @Override
    public boolean validate() {
        return false;
    }

    private void sort(List<Point> vertexes) {
        Point origin = new Point(0, 0);

        Point leftDown = vertexes.get(0);
        double minLength = new Line(origin, vertexes.get(0)).calculate();
        for (int i = 1; i < vertexes.size(); i++) {
            double compareLength = new Line(origin, vertexes.get(i)).calculate();

            if (minLength > compareLength) {
                minLength = compareLength;
                leftDown = vertexes.get(i);
            }
        }

        vertexes.remove(leftDown);
        this.vertexes[0] = leftDown;

        Point rightUp = vertexes.get(0);
        double maxLength = new Line(leftDown, vertexes.get(0)).calculate();
        for (int i = 1; i < vertexes.size(); i++) {
            double compareLength = new Line(leftDown, vertexes.get(i)).calculate();

            if (maxLength < compareLength) {
                maxLength = compareLength;
                rightUp = vertexes.get(i);
            }
        }

        vertexes.remove(rightUp);
        this.vertexes[4] = rightUp;
        this.vertexes[1] = vertexes.get(0);
        this.vertexes[2] = vertexes.get(1);
    }

    @Override
    public Point[] getVertex() {
        return Arrays.copyOf(vertexes, 4);
    }

    @Override
    public double calculate() {
        int width = vertexes[0].getX() - vertexes[1].getX();
        int height = vertexes[0].getY() - vertexes[2].getY();
        return width * height;
    }
}
