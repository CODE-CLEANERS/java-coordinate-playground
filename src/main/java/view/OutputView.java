package view;

public class OutputView {

    public void msgInputPoints() {
        System.out.println("좌표를 입력하세요.");
    }

    public void msgOutputLine(double result) {
        System.out.println("두 점 사이의 거리는 "+result);
    }

    public void msgOutputSquare(double result) {
        System.out.println("사각형 넓이는 "+result);
    }

    public void msgOutputTriangle(double result) {
        System.out.println("삼각형 넓이는 "+result);
    }

}
