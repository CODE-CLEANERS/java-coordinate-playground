package calculator;

import domain.Coordinate;

import java.io.IOException;
import java.util.List;

public class CalculatorFactory {
    private List<Coordinate> coordinateList;
    private double result;


    public CalculatorFactory(List<Coordinate> coordinateList,double result) {
        this.coordinateList = coordinateList;
        this.result = result;
    }

    public Calculator calculateFactory(String[] splitInput) throws IOException {
        coordinateList = addCoordinate(splitInput);

        if(coordinateList.size() == 2){
            return new CoordinateLengthCalculator(coordinateList);
        }
        if(coordinateList.size() == 3){
            return new TriangleCalculator(coordinateList);
        }
        if(coordinateList.size() == 4){
            return new SquareCalculator(coordinateList);
        }
        return null;
    }

    private List<Coordinate> addCoordinate(String[] splitInput) throws IOException {
        for (String originalCoordinate:splitInput) {
            Coordinate coordinate = new Coordinate(originalCoordinate);
            coordinateList.add(coordinate);
        }
        return coordinateList;
    }

}
