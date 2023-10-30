package calculator;

import domain.Coordinate;

import java.util.List;

public class TriangleCalculator implements Calculator{
    List<Coordinate> coordinateList;
    double result;

    public TriangleCalculator(List<Coordinate> coordinateList, double result) {
        this.coordinateList = coordinateList;
        this.result = result;
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
        result = Math.sqrt(s * (s - lineLengthAB) * (s - lineLengthBC) * (s - lineLengthCA));
        return result;
    }

    @Override
    public int getCoordinateCount() {
        return coordinateList.size();
    }

    private double calculateLineLength(Coordinate coordinateA, Coordinate coordinateB){
        int x = Math.abs(coordinateA.getX() - coordinateB.getX());
        int y = Math.abs(coordinateA.getY() - coordinateB.getY());
        double somPow = Math.pow(x, 2) + Math.pow(y, 2);
        result = Math.sqrt(somPow);
        return result;
    }
}
