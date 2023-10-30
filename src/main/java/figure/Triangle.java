package figure;

import java.util.Arrays;
import java.util.List;

public class Triangle extends AbstractFigure{
    public Triangle(List<Dot> dotList) {
        super(dotList);
    }

    @Override
    public String getName() {
        return FigureEnum.TRIANGLE.getName();
    }

    @Override
    public int size() {
        return FigureEnum.TRIANGLE.getSize();
    }

    @Override
    public double getArea() {
        return calculateArea();
    }
    private double getLineLength(int firstIdx, int secondIdx){
        Dot dot = getDot(firstIdx);
        Dot secondDot = getDot(secondIdx);
        return dot.getDistanceBetween(secondDot);
    }

    //헤론의 공식
    //s = (a + b + c) / 2
    //Area = √(s * (s - a) * (s - b) * (s - c))
    private double calculateArea(){
        double[] lengths = new double[3];

        for (int i = 0; i < size(); i++) {
            lengths[i] = this.getLineLength(i, (i + 1) % 3);
        }

        double s = Arrays.stream(lengths).sum() / 2;

        return Math.sqrt(s * (s - lengths[0]) * (s - lengths[1]) * (s - lengths[2]));
    }

}
