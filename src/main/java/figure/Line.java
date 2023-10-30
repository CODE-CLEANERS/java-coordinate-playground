package figure;

import java.util.List;

public class Line extends AbstractFigure {

    public Line(List<Dot> dotList) {
        super(dotList);
    }

    @Override
    public String getName() {
        return FigureEnum.LINE.getName();
    }

    @Override
    public int size() {
        return FigureEnum.LINE.getSize();
    }

    @Override
    public double getArea() {
        return getLineDistance();
    }

    private double getLineDistance() {
        Dot dot = this.getDot(0);
        Dot secondDot = this.getDot(1);
        return dot.getDistanceBetween(secondDot);
    }
}
