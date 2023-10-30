package coordinate;

public class Line {
    private final Point start;
    private final Point end;
    private final double length;

    public Line(Point one, Point two) {
        start = one;
        end = two;
        length = Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
    }

    public double getLength() {
        return length;
    }
}
