package coordinate.geometricelement;

public abstract class Shape {

    protected final Point[] vertexes;

    protected Shape(Point[] in) {
        this.vertexes = new Point[in.length];
    }

    abstract void validate();

    abstract Point[] getVertex();
}
