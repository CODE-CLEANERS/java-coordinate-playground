package figure;

import java.util.List;

@FunctionalInterface
public interface FactoryFunction {
    Figure create(List<Dot> dotList);
}
