package calculator;

import java.util.Objects;

public class Dot {
    private final int x;
    private final int y;

    public Dot(int x, int y) {
        validateLocations(x, y);
        this.x = x;
        this.y = y;
    }

    public Dot(String input) {
        String[] parts = input.replaceAll("[()]", "").split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid input format");
        }
        int x = Integer.parseInt(parts[0].trim());
        int y = Integer.parseInt(parts[1].trim());
        validateLocations(x, y);
        this.x = x;
        this.y = y;
    }


    private void validateLocations(int x, int y) {
        if (x > 24 || y > 24) throw new IllegalArgumentException();
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

    public double getDistanceBetween(Dot secondDot) {
        return Math.sqrt(Math.pow((secondDot.x - this.x), 2) + Math.pow((secondDot.y - this.y), 2));
    }
}
