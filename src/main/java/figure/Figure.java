package figure;

import java.util.List;

public interface Figure {
    String getName();
    int size();
    double getArea();
    List<Dot> getDots();
}
