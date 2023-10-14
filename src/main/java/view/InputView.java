package view;

import domain.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<Point> inputPoints() {

        List<Point> points = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();

            String[] pointsStr = line.split("-");

            for(int i=0; i< pointsStr.length; i++) {

                points.add(Point.inputStrSeparator(pointsStr[i]));

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return points;
    }

}
