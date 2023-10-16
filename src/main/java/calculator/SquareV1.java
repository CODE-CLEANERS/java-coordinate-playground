package calculator;

public class SquareV1 {
    private final Dots dots;

    public SquareV1(Dots dots) {
        if (!dots.isSquare()){
            throw new IllegalArgumentException();
        }
        this.dots = dots;
    }

    public int getArea() {
        return this.dots.getSquareArea();
    }
}
