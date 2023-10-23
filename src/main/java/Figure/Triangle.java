package Figure;

import domain.Point;
import domain.Points;

public class Triangle implements Calculator {

    private Points points;

    public Triangle(Points points) {
        this.points = points;
    }

    @Override
    public double calculate() {

        Point pointA = points.getPoint(0);
        Point pointB = points.getPoint(1);
        Point pointC = points.getPoint(2);

        double area = 0.5 * (
                this.getTriangleLine(pointA, pointB, pointC) +
                this.getTriangleLine(pointB, pointC, pointA) +
                this.getTriangleLine(pointC, pointA, pointB)
        );

        return Math.abs(area);

    }

    private int getTriangleLine(Point pointA, Point pointB, Point pointC) {
        return pointA.getX() * (pointB.getY() - pointC.getY());
    }

}
