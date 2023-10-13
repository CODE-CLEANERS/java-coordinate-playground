package domain;

import java.util.List;

public class Points {

    private List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public Point getPoint(int idx) {
        return points.get(idx);
    }
}
