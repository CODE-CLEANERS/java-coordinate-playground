package domain;

import utils.Constants;

public class Point {

    private int x;
    private int y;

    private Point(int x, int y) {

        this.x = x;
        this.y = y;

    }

    public static Point newInstance(int x, int y) {

        if (x < 0 || x > 24 || y < 0 || y > 24) {
            throw new IllegalArgumentException(Constants.INPUT_RANGE_CHECK);
        }

        return new Point(x, y);
    }

    public static Point inputStrSeparator(String inStr) {

        String[] values = inStr.replaceAll("[()]", "").split(",");

        return newInstance(Integer.parseInt(values[0]), Integer.parseInt(values[1]));

    }

    public double getDifferDistance(Point point) {

        return Math.sqrt(Math.pow(x - point.getX(), 2) + Math.pow(x - point.getY(), 2));

    }

    public int getX() {

        return this.x;

    }

    public int getY() {

        return this.y;

    }

}
