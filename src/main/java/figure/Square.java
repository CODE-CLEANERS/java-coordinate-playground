package figure;

import calculator.DotV1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Square extends AbstractFigure{

    protected Square(List<Dot> dotList) {
        super(dotList);
    }

    @Override
    public String getName() {
        return FigureEnum.SQUARE.getName();
    }

    @Override
    public int size() {
        return FigureEnum.SQUARE.getSize();
    }

    @Override
    public double getArea() {
        return getSquareArea();
    }

    private double getSquareArea(){
        List<Double> collect = IntStream.range(0, 4)
                .mapToObj(i -> getDot(i).getDistanceBetween(getDots().get((i + 1) % 4)))
                .distinct().collect(Collectors.toList());

        if (collect.size() == 1) return (int) Math.pow(collect.get(0), 2);

        return collect.get(0)  * collect.get(1);
    }

}
