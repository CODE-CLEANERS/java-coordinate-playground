package Figure;

import domain.Point;
import domain.Points;

public class Line {

    Points points;

    public Line(Points points) {
        this.points = points;
    }

    public double getLength() {

        Point point1 = points.getPoint(0);
        Point point2 = points.getPoint(1);

        return point1.getDifferDistance(point2);
    }
}
