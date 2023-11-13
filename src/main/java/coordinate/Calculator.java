package coordinate;

public class Calculator {

    public boolean validatePoints(Point[] points) {
        for (Point point : points) {
            if (point.getX() < 1) {
                return false;
            }

            if (point.getY() > 24) {
                return false;
            }
        }

        return true;
    }

    public Point[] toPoints(String input) {
        String[] points = input.split("-");
        Point[] result = new Point[points.length];

        for (int i = 0; i < points.length; i++) {
            String[] coordinate = points[i].replace("(", "")
                    .replace(")", "")
                    .split(",");

            result[i] = new Point(Integer.parseInt(coordinate[0].trim()), Integer.parseInt(coordinate[1].trim()));
        }

        return result;
    }

    public GeometricElement getShape(Point[] points) {
        if (points.length == 2) {
            return new Line(points[0], points[1]);
        }

        throw new ArithmeticException("No Shape");
    }
}
