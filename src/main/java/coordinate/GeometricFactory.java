package coordinate;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static exception.ExceptionMessage.NO_LINE_OR_SHAPE;

public class GeometricFactory {

    private final static Map<Integer, Class<? extends GeometricElement>> GEOMETRIC_ELEMENTS = new HashMap<>();

    static {
        int linesPointCount = 2;
        int rectanglesPointCount = 4;
        int trianglesPointCount = 3;

        GEOMETRIC_ELEMENTS.put(linesPointCount, Line.class);
        GEOMETRIC_ELEMENTS.put(rectanglesPointCount, Rectangle.class);
        GEOMETRIC_ELEMENTS.put(trianglesPointCount, Triangle.class);
    }

    public static GeometricElement getGeometricElement(Point[] points) {
        if (!GEOMETRIC_ELEMENTS.containsKey(points.length)) {
            throw new ArithmeticException(NO_LINE_OR_SHAPE.getMessage());
        }

        try {
            Class<? extends GeometricElement> geometricElementClass = GEOMETRIC_ELEMENTS.get(points.length);
            return geometricElementClass.getDeclaredConstructor(Point[].class).newInstance((Object) points);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
