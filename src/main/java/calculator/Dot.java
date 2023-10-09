package calculator;

import java.util.Objects;

public class Dot {
    private final int x;
    private final int y;
    private static final String INVALID_INPUT_FORMAT = "Invalid input format";
    private static final String REGEX_FOR_STRING_INPUT = "[()]";
    private static final int MAX_LOCATION_FOR_DOT = 24;
    public Dot(int x, int y) {
        validateLocations(x, y);
        this.x = x;
        this.y = y;
    }

    public Dot(String input) {
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

    public double getDistanceBetween(Dot secondDot) {
        return Math.sqrt(Math.pow((secondDot.x - this.x), 2) + Math.pow((secondDot.y - this.y), 2));
    }
    public boolean isXParallel(Dot dot) {
        return this.y == dot.y;
    }

    public boolean isYParallel(Dot dot) {
        return this.x == dot.x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return x == dot.x && y == dot.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
