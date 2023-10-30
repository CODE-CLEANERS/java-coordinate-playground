package coordinate;

import coordinate.util.Bool;
import coordinate.util.Points;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    private final Points points = new Points();

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
        System.out.println("좌표를 입력하세요.");
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
            System.out.println("올바른 개수의 좌표값을 입력해주세요.");
            result.toFalse();
            return;
        }

        int x = 0;
        int y = 0;

        try {
            x = Integer.parseInt(coordinate[0]);
            y = Integer.parseInt(coordinate[1]);
        } catch (NumberFormatException e) {
            System.out.println("올바른 좌표값을 입력해주세요.");
        }

        if (x <= 0 || x > 24 || y <= 0 || y > 24) {
            System.out.println("X, Y좌표 모두 최소 0, 최대 24까지만 입력할 수 있습니다.");
            result.toFalse();
            return;
        }

        Point point = new Point(x, y);
        points.add(point);
    }
}
