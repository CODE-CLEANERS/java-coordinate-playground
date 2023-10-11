package calculator;

public class Line {
    private final Dots dots;

    public Line(Dots dots) {
        this.dots = dots;
    }

    public Line(Dot first, Dot second){
        this.dots = Dots.asLine(first, second);
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