package figure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private final List<Figure> figureList;
    private static final Map<Integer, Figure> figureMap = new HashMap<>();

    public FigureFactory(List<Figure> figureList) {
        this.figureList = figureList;
        for (Figure figure : figureList) {
            figureMap.put(figure.size(), figure);
        }
    }

    static Figure getInstance(List<Dot> points) {
        return figureMap.get(points.size());
    }
}