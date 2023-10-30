package view;

import calculator.Calculator;
import domain.Coordinate;

import java.util.List;

public class OutputView {


    public String resultOutput(Calculator calculator, double result){
        if(calculator.getCoordinateCount()==2) return String.format("두 좌표의 길이는 %.6f",result);
        if(calculator.getCoordinateCount()==3) return String.format("삼각형의 넓이는 %.2f",result);
        if(calculator.getCoordinateCount()==4) return String.format("사각형의 넓이는 %.1f",result);

        return "";
        };
    }

