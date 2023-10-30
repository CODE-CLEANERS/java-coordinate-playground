package coordinate;

import coordinate.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static coordinate.util.Message.*;

public class Calculator {

    private final Points points = new Points();
    private final View view = ConsoleView.getInstance();

    public double calculate() throws IOException {
        boolean isInputEnd = false;
        while (!isInputEnd) {
            points.clear();
            isInputEnd = input();
        }

        if (points.size() == 2) {
            Line line = new Line(points.get(0), points.get(1));
            return line.getLength();
        }

        return -1d;
    }

    public boolean input() throws IOException {
        Bool result = new Bool(true);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        view.print(INPUT_INFO_MESSAGE);
        String input = br.readLine();
        input = input.replaceAll("[()]", "");
        String[] split = input.split("-");

        for (String s : split) {
            String[] coordinate = s.split(",");
            toPoint(coordinate, result);
        }

        return result.get();
    }

    public void toPoint(String[] coordinate, Bool result) {
        if (coordinate.length != 2) {
            view.print(NOT_ENOUGH_INPUT);
            result.toFalse();
            return;
        }

        int x;
        int y;

        try {
            x = Integer.parseInt(coordinate[0]);
            y = Integer.parseInt(coordinate[1]);
        } catch (NumberFormatException e) {
            view.print(NO_NUMBER);
            result.toFalse();
            return;
        }

        if (x <= 0 || x > 24 || y <= 0 || y > 24) {
            view.print(OUT_OF_RANGE);
            result.toFalse();
            return;
        }

        Point point = new Point(x, y);
        points.add(point);
    }
}
