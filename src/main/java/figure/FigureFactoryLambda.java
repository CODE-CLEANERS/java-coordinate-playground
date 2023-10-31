package figure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactoryLambda {
    private FigureFactoryLambda() {
        throw new IllegalArgumentException("util class");
    }
    private static final Map<Integer, Function<List<Dot>, Figure>> figureMap = new HashMap<>();
    private static final Map<Integer, FactoryFunction> figureMap2 = new HashMap<>();
    static {
        figureMap2.put(2, Line::new);
        figureMap2.put(3, Triangle::new);
        figureMap2.put(4, Square::new);
    }
    static {
        figureMap.put(2, Line::new);
        figureMap.put(3, Triangle::new);
        figureMap.put(4, Square::new);
    }
    public static Figure getInstance(List<Dot> dotList){
        Function<List<Dot>, Figure> figureFunction = figureMap.get(dotList.size());
        return figureFunction.apply(dotList);
    }
    public static Figure getInstanceByCustomFunction(List<Dot> dotList){
        FactoryFunction factoryFunction = figureMap2.get(dotList.size());
        return factoryFunction.create(dotList);
    }
}