package calculator;

import domain.Coordinate;

import java.io.IOException;
import java.util.List;

public class CalculatorFactory {
    List<Coordinate> coordinateList;
    double result;


    public CalculatorFactory(List<Coordinate> coordinateList,double result) {
        this.coordinateList = coordinateList;
        this.result = result;
    }

    public Calculator calculateFactory(String[] splitInput) throws IOException {
        coordinateList = addCoordinate(splitInput);

        if(coordinateList.size() == 2){
            return new CoordinateLengthCalculator(coordinateList,result);
        }
        if(coordinateList.size() == 3){
            return new TriangleCalculator(coordinateList,result);
        }
        if(coordinateList.size() == 4){
            return new SquareCalculator(coordinateList,result);
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
