package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dots {
    private final List<Dot> dots;

    /**
     * CONSTANTS
     */
    private static final String SPLIT_EXPRESSION = "-";
    private static final String IS_NOT_LINE = "선이 아니다.";
    private static final String IS_NOT_SQUARE = "사각형이 아니다.";
    public Dots(String input) {
        validateInput(input);
        this.dots = Arrays.stream(input.split("-")).map(Dot::new).collect(Collectors.toList());
    }

    /**
     * validations & common methods
     */
    private void validateInput(String input) {
        if (!input.contains(SPLIT_EXPRESSION)){
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return this.dots.size();
    }

    /**
     * line methods
     */
    public boolean isLine() {
        return this.dots.size() == 2;
    }

    public boolean isXParallelLine(){
        if (!isLine()) {
            throw new IllegalArgumentException(IS_NOT_LINE);
        }
        return dots.get(0).isXParallel(dots.get(1));
    }

    public boolean isYParallelLine(){
        if (!isLine()) {
            throw new IllegalArgumentException(IS_NOT_LINE);
        }
        return dots.get(0).isYParallel(dots.get(1));
    }

    public double getDistanceBetween(){
        if (!this.isLine()) {
            throw new IllegalArgumentException(IS_NOT_LINE);
        }
        return this.dots.get(0).getDistanceBetween(dots.get(1));
    }

    /**
     * square methods
     */
    public boolean isSquare() {
        if (this.dots.size() != 4) {
            return false;
        }
        return isAllParallel();
    }

    public boolean isAllParallel() {
        return IntStream.range(0, 4).allMatch(i -> {
            Dot dot1 = dots.get(i);
            Dot dot2 = dots.get((i + 1) % 4); // 다음 점
            return dot1.isXParallel(dot2) || dot1.isYParallel(dot2);
        });
    }

    public int getSquareArea(){
        if (!isSquare()) {
            throw new IllegalArgumentException(IS_NOT_SQUARE);
        }

        List<Double> collect = IntStream.range(0, 4)
                .mapToObj(i -> dots.get(i).getDistanceBetween(dots.get((i + 1) % 4)))
                .distinct().collect(Collectors.toList());

        if (collect.size() == 1) return (int) Math.pow(collect.get(0), 2);
        return (int) (collect.get(0)  * collect.get(1));
    }
}