package coordinate.util;

import coordinate.Point;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private final List<Point> points = new ArrayList<>();

    public void add(Point point) {
        points.add(point);
    }

    public Point get(int index) {
        return points.get(index);
    }

    public void clear() {
        points.clear();
    }

    public int size() {
        return points.size();
    }
}
