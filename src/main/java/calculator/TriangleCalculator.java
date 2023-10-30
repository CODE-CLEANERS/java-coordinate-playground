package calculator;

import domain.Coordinate;

import java.util.List;

public class TriangleCalculator implements Calculator{
    private final List<Coordinate> coordinateList;

    public TriangleCalculator(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    @Override
    public double calculator() {
        //꼭지점 A,B,C
        Coordinate coordinateA = coordinateList.get(0);
        Coordinate coordinateB = coordinateList.get(1);
        Coordinate coordinateC = coordinateList.get(2);
        //변AB,변BC,변CA 의 길이
        double lineLengthAB = calculateLineLength(coordinateA, coordinateB);
        double lineLengthBC = calculateLineLength(coordinateB, coordinateC);
        double lineLengthCA = calculateLineLength(coordinateC, coordinateA);
        //헤론의 법칙 :(변AB+변BC+변CA)/2 = s
        double s = (lineLengthAB + lineLengthBC + lineLengthCA)/2;
        // 루트(s*(s-AB)*(s-BC)*(s-CA))
        return Math.sqrt(s * (s - lineLengthAB) * (s - lineLengthBC) * (s - lineLengthCA));
    }

    @Override
    public int getCoordinateCount() {
        return coordinateList.size();
    }

    private double calculateLineLength(Coordinate coordinateA, Coordinate coordinateB){
        int x = Math.abs(coordinateA.getX() - coordinateB.getX());
        int y = Math.abs(coordinateA.getY() - coordinateB.getY());
        double somPow = Math.pow(x, 2) + Math.pow(y, 2);
        return Math.sqrt(somPow);
    }
}
