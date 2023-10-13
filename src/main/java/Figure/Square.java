package Figure;

import domain.Point;
import domain.Points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Square {

    Points points;

    public Square(Points points) {
        this.points = points;
    }

    public double getArea() {

        Point stand = points.getPoint(0);

        List<Double> lens = new ArrayList<>();

        for(int i=1; i<4; i++) {
            lens.add(stand.getDifferDistance(points.getPoint(i)));
        }

        Collections.sort(lens);

        return lens.get(0)*lens.get(1);
    }

}
