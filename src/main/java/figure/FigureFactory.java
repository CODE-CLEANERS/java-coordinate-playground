package figure;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private FigureFactory() {
        throw new IllegalArgumentException("util class");
    }

    private static final Map<Integer, Class<? extends Figure>> figureMap = new HashMap<>();

    static {
        figureMap.put(FigureEnum.LINE.getSize(), Line.class);
        figureMap.put(FigureEnum.TRIANGLE.getSize(), Triangle.class);
        figureMap.put(FigureEnum.SQUARE.getSize(), Square.class);
    }

    public static Figure getInstance(List<Dot> points) {
        Class<? extends Figure> figureClass = figureMap.get(points.size());
        if (figureClass == null) {
            throw new IllegalArgumentException("잘못된 입력");
        }
        try {
            return figureClass.getConstructor(List.class).newInstance(points);
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 도형");
        }
    }
}