package coordinate;

import java.util.Arrays;

public class PointConverter {

    public static Point[] getPoints(String xStr, String yStr) {
        int[] x = getArray(xStr);
        int[] y = getArray(yStr);

        Point[] points = new Point[x.length];
        for (int i = 0; i < x.length; i++) {
            Point point = new Point(x[i], y[i]);
            points[i] = point;
        }

        return points;
    }

    public static int[] getArray(String s) {
        return Arrays.stream(s.replace("[", "").replace("]", "").split(","))
                .mapToInt(c -> Integer.parseInt(c.trim()))
                .toArray();
    }
}
