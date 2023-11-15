package coordinate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static Point[] toPoints(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("No Input.");
        }

        Pattern pattern = Pattern.compile("\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(input);

        int hit = 0;
        while (matcher.find()) {
            hit++;
        }
        Point[] result = new Point[hit];

        matcher.reset();
        for (int i = 0; i < result.length && matcher.find(); i++) {
            String[] coordinate = matcher.group().replaceAll("[()]", "")
                    .split(",");

            if (coordinate.length != 2 || isBlank(coordinate[0]) || isBlank(coordinate[1])) {
                throw new ArithmeticException("The input is not a two dimension point.");
            }

            int x = validationNumberAndGet(coordinate[0]);
            int y = validationNumberAndGet(coordinate[1]);
            result[i] = new Point(x, y);
        }

        return result;
    }

    private static boolean isBlank(String in) {
        return in == null || in.trim().isEmpty();
    }

    private static int validationNumberAndGet(String in) {
        in = in.trim();
        // "-" 부호만 입력 했을 때는 0으로 간주됨
        if (in.charAt(0) != '-' && !Character.isDigit(in.charAt(0))) {
            throw new ArithmeticException("The input is not a number.");
        }

        for (int i = 1; i < in.length(); i++) {
            boolean isDigit = Character.isDigit(in.charAt(i));
            if (!isDigit) {
                throw new ArithmeticException("The input is not a number.");
            }
        }

        int num = Integer.parseInt(in);
        if (num < 1 || num > 24) {
            throw new IllegalArgumentException("allow range for input is from 1 to 24.");
        }

        return num;
    }

    public static GeometricElement getGeometricElement(Point[] points) {
        if (points.length == 2) {
            return new Line(points);
        }

        if (points.length == 4) {
            return new Rectangle(points);
        }

        if (points.length == 3) {
            return new Triangle(points);
        }

        throw new ArithmeticException("No Line or Shape");
    }
}
