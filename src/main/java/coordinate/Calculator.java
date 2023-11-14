package coordinate;

public class Calculator {

    public static boolean validatePoints(Point[] points) {
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

    public static Point[] toPoints(String input) {
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

    public static GeometricElement getGeometricElement(Point[] points) {
        if (points.length == 2) {
            return new Line(points[0], points[1]);
        }

        if (points.length == 4) {
            return new Rectangle(points[0], points[1], points[2], points[3]);
        }

        if (points.length == 3) {
            return new Triangle(points[0], points[1], points[2]);
        }

        throw new ArithmeticException("No Line or Shape");
    }
}
