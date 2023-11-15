package coordinate;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + this.x;
        result = 37 * result + this.y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Point.class) {
            return false;
        }

        Point compare = (Point) obj;
        return compare.x == this.x && compare.y == this.y;
    }
}
