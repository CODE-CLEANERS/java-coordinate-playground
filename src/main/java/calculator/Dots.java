package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dots {
    private final List<DotV1> dotV1s;

    /**
     * CONSTANTS
     */
    private static final String SPLIT_EXPRESSION = "-";
    private static final String IS_NOT_LINE = "선이 아니다.";
    private static final String IS_NOT_SQUARE = "사각형이 아니다.";

    public Dots(String input) {
        validateInput(input);
        this.dotV1s = Arrays.stream(input.split("-")).map(DotV1::new).collect(Collectors.toList());
    }

    private Dots(DotV1 first, DotV1 second){
        this.dotV1s = new ArrayList<>();
        dotV1s.add(first);
        dotV1s.add(second);
    }

    public static Dots asLine(DotV1 first, DotV1 second){
        return new Dots(first, second);
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
        return this.dotV1s.size();
    }

    /**
     * line methods
     */
    public boolean isLine() {
        return this.dotV1s.size() == 2;
    }

    public boolean isXParallelLine(){
        if (!isLine()) {
            throw new IllegalArgumentException(IS_NOT_LINE);
        }
        return dotV1s.get(0).isXParallel(dotV1s.get(1));
    }

    public boolean isYParallelLine(){
        if (!isLine()) {
            throw new IllegalArgumentException(IS_NOT_LINE);
        }
        return dotV1s.get(0).isYParallel(dotV1s.get(1));
    }

    public double getDistanceBetween(){
        if (!this.isLine()) {
            throw new IllegalArgumentException(IS_NOT_LINE);
        }
        return this.dotV1s.get(0).getDistanceBetween(dotV1s.get(1));
    }

    /**
     * square methods
     */
    public boolean isSquare() {
        if (this.dotV1s.size() != 4) {
            return false;
        }
        return isAllParallel();
    }

    public boolean isAllParallel() {
        return IntStream.range(0, 4).allMatch(i -> {
            DotV1 dotV1 = dotV1s.get(i);
            DotV1 dotV12 = dotV1s.get((i + 1) % 4); // 다음 점
            return dotV1.isXParallel(dotV12) || dotV1.isYParallel(dotV12);
        });
    }

    public int getSquareArea(){
        if (!isSquare()) {
            throw new IllegalArgumentException(IS_NOT_SQUARE);
        }

        List<Double> collect = IntStream.range(0, 4)
                .mapToObj(i -> dotV1s.get(i).getDistanceBetween(dotV1s.get((i + 1) % 4)))
                .distinct().collect(Collectors.toList());

        if (collect.size() == 1) return (int) Math.pow(collect.get(0), 2);
        return (int) (collect.get(0)  * collect.get(1));
    }

    /**
     * triangle
     */
    public boolean isTriangle() {
        return this.dotV1s.size() == 3;
    }

    public double getLinesLength(){
        double lineLength = 0;
        for (int i = 0; i < this.dotV1s.size(); i++) {
            DotV1 first = dotV1s.get(i);
            DotV1 second = dotV1s.get((i + 1) % dotV1s.size());
            LineV1 lineV1 = new LineV1(first, second);
            lineLength += lineV1.getDotsDistance();
        }
        return lineLength;
    }

    //헤론의 공식
    //s = (a + b + c) / 2
    //Area = √(s * (s - a) * (s - b) * (s - c))
    public double getTriangleArea(){
        List<Double> lineLengths = new ArrayList<>();
        for (int i = 0; i < this.dotV1s.size(); i++) {
            DotV1 first = dotV1s.get(i);
            DotV1 second = dotV1s.get((i + 1) % dotV1s.size());
            LineV1 lineV1 = new LineV1(first, second);
            lineLengths.add(lineV1.getDotsDistance());
        }
        double area = getLinesLength() / 2;
        for (Double lineLength : lineLengths) {
            area *= (getLinesLength() / 2) - lineLength;
        }
        return Math.sqrt(area);
    }
}