import coordinate.Calculator;
import coordinate.GeometricElement;
import coordinate.Point;
import util.Plate;
import util.Terminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String in = Terminal.in("좌표를 입력하세요." + System.lineSeparator());
        Point[] points = Calculator.toPoints(in);
        if (Calculator.validatePoints(points)) {
            Plate plate = new Plate();
            plate.drawPoints(points);
            plate.print();
            GeometricElement geometricElement = Calculator.getGeometricElement(points);
            geometricElement.printCalculateResult();
        }
    }
}
