package view;

import domain.Point;
import domain.Type;
import utils.Constants;

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

            InputView.validInputFormat(line);

            String[] pointsStr = line.split("-");

            for(int i=0; i< pointsStr.length; i++) {

                points.add(Point.inputStrSeparator(pointsStr[i]));

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return points;
    }

    public static void validInputFormat(String inStr) {

        String[] strArr = inStr.split("-");

        if(strArr.length != Type.LINE.getCount() && strArr.length != Type.LINE.getCount() && strArr.length != Type.LINE.getCount()) {
            throw new IllegalArgumentException(Constants.INPUT_FORMAT_CHECK);
        }

        for(String str:strArr) {
            String[] checkArr = str.replaceAll("[()]", "").split(",");

            if(checkArr.length!=2) throw new IllegalArgumentException(Constants.INPUT_FORMAT_CHECK);

            try {
                Integer.parseInt(checkArr[0]);
                Integer.parseInt(checkArr[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Constants.INPUT_FORMAT_CHECK);
            }
        }

    }
}
