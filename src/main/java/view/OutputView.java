package view;

import figure.Dot;
import figure.Figure;
import figure.FigureFactory;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private OutputView() {
        throw new IllegalArgumentException();
    }

    public static void printGetInput(){
        System.out.println("숫자를 입력해라");
    }

    public static void printOutput(String[] userInputs){
        List<Dot> dotList = new ArrayList<>();
        for (String userInput : userInputs) {
            dotList.add(Dot.of(userInput));
        }
        Figure instance = FigureFactory.getInstance(dotList);
        String name = instance.getName();
        double area = instance.getArea();
        System.out.println(name + "의 Area 는 : " + area + "이다.");
    }
}
