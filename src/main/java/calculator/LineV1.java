package calculator;

public class LineV1 {
    private final Dots dots;

    public LineV1(Dots dots) {
        this.dots = dots;
    }

    public LineV1(DotV1 first, DotV1 second){
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