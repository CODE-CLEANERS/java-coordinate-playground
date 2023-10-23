package domain;

import java.util.List;

public class Points {

    private List<Point> points;

    private Points(List<Point> points) {
        this.points = points;
    }

    public static Points newInstance(List<Point> points) {
        return new Points(points);
    }

    public Point getPoint(int idx) {
        return points.get(idx);
    }

    public int getSize() {
        return points.size();
    }
}
