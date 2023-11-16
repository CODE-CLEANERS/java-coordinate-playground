package coordinate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static exception.ExceptionMessage.*;

public class PointMaker {

    public static Point[] toPoints(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(NO_INPUT.getMessage());
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
                throw new ArithmeticException(NO_TWO_DIMENSION_POINT.getMessage());
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
            throw new ArithmeticException(INPUT_NOT_NUMBER.getMessage());
        }

        for (int i = 1; i < in.length(); i++) {
            boolean isDigit = Character.isDigit(in.charAt(i));
            if (!isDigit) {
                throw new ArithmeticException(INPUT_NOT_NUMBER.getMessage());
            }
        }

        int rangeMin = 1;
        int rangeMax = 24;

        int num = Integer.parseInt(in);
        if (num < rangeMin || num > rangeMax) {
            throw new IllegalArgumentException(String.format(INPUT_OUT_OF_RANGE.getMessage(), rangeMin, rangeMax));
        }

        return num;
    }
}
