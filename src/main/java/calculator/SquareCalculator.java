package calculator;

import domain.Coordinate;

import java.io.IOException;
import java.util.List;

public class SquareCalculator implements Calculator{
    private final List<Coordinate> coordinateList;

    public SquareCalculator(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    @Override
    public double calculator() throws IOException {
        System.out.println("사각형 넓이 구하기");
        //삐뚤어진 사각형인지 아닌지 먼저 검증
        validateSquare();
        //가로길이 구하기
        double width = calculateWidth(coordinateList);
        //세로길이 구하기
        double height = calculateHeight(coordinateList);
        //넓이 계산하기
        return width * height;
    }

    private void validateSquare() throws IOException {
        //꼭지점 A(x,y), B(x,y),C(x,y),D(x,y)
        //정사각형 또는 직사각형은 x가 두개가 같고 y가 두개가 같다.
        int referenceX = coordinateList.get(0).getX();
        int referenceY = coordinateList.get(0).getY();
        int count = 0;

        for (int i = 1; i < coordinateList.size(); i++) {
            if(coordinateList.get(i).getX()==referenceX &&coordinateList.get(i).getY() == referenceY){
                throw new IOException("정사각형 또는 직사각형의 좌표를 입력해주세요.");
            }
            if(coordinateList.get(i).getX()==referenceX || coordinateList.get(i).getY() == referenceY){
                count++;
            }
        }

        if (!(count ==2)){
            throw new IOException("정사각형 또는 직사각형의 좌표를 입력해주세요.");
        }

    }

    @Override
    public int getCoordinateCount() {
        return coordinateList.size();
    }

    private double calculateWidth(List<Coordinate> coordinateList){
        //y좌표가 같은것끼리 찾아서 ax-bx를 하면 가로길이 나옴.
        Coordinate aCoordinate;
        Coordinate bCoordinate = null;

        aCoordinate = coordinateList.get(0);

        for (int i = 1; i < coordinateList.size(); i++) {
           if(aCoordinate.getY()==coordinateList.get(i).getY()){
               bCoordinate = coordinateList.get(i);
               break;
           }
        }

        return Math.abs(aCoordinate.getX()-bCoordinate.getX());
    }

    private double calculateHeight(List<Coordinate> coordinateList){
        //x좌표가 같은것끼리 찾아서 ay-by를 하면 세로길이 나옴.
        Coordinate aCoordinate = null;
        Coordinate bCoordinate = null;

        aCoordinate = coordinateList.get(0);

        for (int i = 1; i < coordinateList.size(); i++) {
            if(aCoordinate.getX()==coordinateList.get(i).getX()){
                bCoordinate = coordinateList.get(i);
                break;
            }
        }

        return Math.abs(aCoordinate.getY()-bCoordinate.getY());
    }
}
