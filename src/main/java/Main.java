import calculator.Calculator;
import calculator.CalculatorFactory;
import domain.Coordinate;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        List<Coordinate> coordinateList = new ArrayList<>();
        double result = 0;
        CalculatorFactory calculatorFactory = new CalculatorFactory(coordinateList,result);

        while (result==0){
            try {
                String[] inputArray = inputView.creatCoordinate();
                Calculator calculator = calculatorFactory.calculateFactory(inputArray);
                result = calculator.calculator();
                System.out.println(outputView.resultOutput(calculator,result));
            }catch (IOException e){
                System.out.println(e.getMessage());
                coordinateList.clear();
            }
        }

    }
    }
