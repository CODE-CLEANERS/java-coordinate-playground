import coordinate.PointMaker;
import coordinate.GeometricElement;
import coordinate.GeometricFactory;
import coordinate.Point;
import util.Plate;
import util.Terminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String in = Terminal.in("좌표를 입력하세요." + System.lineSeparator());
        Point[] points = PointMaker.toPoints(in);
        Plate plate = new Plate();
        plate.drawPoints(points);
        plate.print();
        GeometricElement geometricElement = GeometricFactory.getGeometricElement(points);
        geometricElement.printCalculateResult();
    }
}
