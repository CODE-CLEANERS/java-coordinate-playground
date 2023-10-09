package calculator;

public class Line {
    private final Dots dots;

    public Line(Dots dots) {
        this.dots = dots;
    }

    public double getDotsDistance(){
        return this.dots.getDistanceBetween();
    }

    public boolean isXParallel() {
        return this.dots.isXParallelLine();
    }

    public boolean isYParallel(){
        return this.dots.isYParallelLine();
    }
}