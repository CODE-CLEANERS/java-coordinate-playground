package calculator;

import java.util.Objects;

public class DotV1 {
    private final int x;
    private final int y;
    private static final String INVALID_INPUT_FORMAT = "Invalid input format";
    private static final String REGEX_FOR_STRING_INPUT = "[()]";
    private static final int MAX_LOCATION_FOR_DOT = 24;
    public DotV1(int x, int y) {
        validateLocations(x, y);
        this.x = x;
        this.y = y;
    }

    public DotV1(String input) {
        String[] parts = input.replaceAll(REGEX_FOR_STRING_INPUT, "").split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
        int x = Integer.parseInt(parts[0].trim());
        int y = Integer.parseInt(parts[1].trim());
        validateLocations(x, y);
        this.x = x;
        this.y = y;
    }

    private void validateLocations(int x, int y) {
        if (x > MAX_LOCATION_FOR_DOT || y > MAX_LOCATION_FOR_DOT) throw new IllegalArgumentException();
    }

    public double getDistanceBetween(DotV1 secondDotV1) {
        return Math.sqrt(Math.pow((secondDotV1.x - this.x), 2) + Math.pow((secondDotV1.y - this.y), 2));
    }
    public boolean isXParallel(DotV1 dotV1) {
        return this.y == dotV1.y;
    }

    public boolean isYParallel(DotV1 dotV1) {
        return this.x == dotV1.x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DotV1 dotV1 = (DotV1) o;
        return x == dotV1.x && y == dotV1.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
