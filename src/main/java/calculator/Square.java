package calculator;

public class Square {
    private final Dots dots;

    public Square(Dots dots) {
        if (!dots.isSquare()){
            throw new IllegalArgumentException();
        }
        this.dots = dots;
    }

    public int getArea() {
        return this.dots.getSquareArea();
    }
}
