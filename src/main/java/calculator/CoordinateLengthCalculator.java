package calculator;

import domain.Coordinate;

import java.io.IOException;
import java.util.List;

public class CoordinateLengthCalculator implements Calculator{
    private final List<Coordinate> coordinateList;

    public CoordinateLengthCalculator(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    @Override
    public  double calculator() {
        int x = Math.abs(coordinateList.get(0).getX() - coordinateList.get(1).getX());
        int y = Math.abs(coordinateList.get(0).getY() - coordinateList.get(1).getY());
        double somPow = Math.pow(x, 2) + Math.pow(y, 2);
        return Math.sqrt(somPow);
    }

    @Override
    public int getCoordinateCount() {
        return coordinateList.size();
    }


}
