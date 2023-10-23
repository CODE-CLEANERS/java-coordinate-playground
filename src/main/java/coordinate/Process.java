package coordinate;

import Figure.Line;
import Figure.Square;
import Figure.Triangle;
import domain.Points;
import domain.Type;
import view.InputView;
import view.OutputView;

public class Process {

    OutputView oView = new OutputView();
    InputView inputView = new InputView();

    public void run() {

        oView.msgInputPoints();

        Points points = Points.newInstance(inputView.inputPoints());

        if(points.getSize()== Type.LINE.getCount()) {

            oView.msgOutputLine(new Line(points).calculate());

        } else if(points.getSize()==Type.TRIANGLE.getCount()) {

            oView.msgOutputTriangle(new Triangle(points).calculate());

        } else if(points.getSize()==Type.RECTANGLE.getCount()) {

            oView.msgOutputSquare(new Square(points).calculate());

        }
    }

}
