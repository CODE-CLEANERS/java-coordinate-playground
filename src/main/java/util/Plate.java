package util;

import coordinate.Point;

import java.util.Arrays;

public class Plate {
    private final String[][] plate;

    public Plate() {
        this.plate = new String[26][26];
        for (int i = 0; i < plate.length; i++) {
            String[] row = new String[27];
            Arrays.fill(row, "   ");
            plate[i] = row;
        }

        for (int i = 0; i < 24; i++) {
            plate[i][1] = "|";
            if ((24 - i) % 2 == 0) {
                plate[i][0] = "  ";
            } else {
                plate[i][0] = String.format("%2d", 24 - i);
            }
        }

        plate[24][0] = "  ";
        plate[24][1] = "+";
        plate[25][0] = " 0";

        for (int i = 2; i < 26; i++) {
            plate[24][i] = "---";
            if ((24 - i) % 2 != 0) {
                plate[25][i] = "   ";
            } else {
                plate[25][i] = String.format(" %-2d", i - 1);
            }
        }

        plate[24][1] = "+";
        plate[25][1] = " ";
    }

    public void drawPoints(Point[] points) {
        for (Point point : points) {
            plate[24 - point.getX()][point.getY() + 1] = " * ";
        }
    }

    public void print() {
        StringBuilder painter = new StringBuilder();
        for (String[] row : plate) {
            for (String data : row) {
                painter.append(data);
            }
            painter.append(System.lineSeparator());
        }

        Terminal.out(painter.toString());
    }
}
